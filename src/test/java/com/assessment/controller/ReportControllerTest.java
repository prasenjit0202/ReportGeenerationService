package com.assessment.controller;

import com.assessment.beans.OutputTransactions;
import com.assessment.repository.TransactionRepository;
import com.assessment.service.TransactionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureMockMvc
public class ReportControllerTest {

    @MockBean
    public TransactionService transactionService;

    @Autowired
    public MockMvc mvc;

    @MockBean
    private TransactionRepository transactionRepository;

    @Autowired
    public ReportController reportController;

    @Test
    public void whenreportControllerInjected_thenNotNull() throws Exception {
        assertThat(reportController).isNotNull();
    }

    @Test
    public void getJsonArrayOfTransaction() throws Exception{

        List<OutputTransactions> transactions = new ArrayList<OutputTransactions>();
        OutputTransactions outputTransactions = new OutputTransactions();
        outputTransactions.setTransactionAmount(BigDecimal.valueOf(10));
        outputTransactions.setProductInformation("ASDFG123456");
        outputTransactions.setClientInformation("1234567GGGG");
        transactions.add(outputTransactions);
        given(transactionService.createReportByDate("2010-10-10")).willReturn(transactions);
        mvc.perform(MockMvcRequestBuilders.get("/generatejsonreport/2010-10-10")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].clientInformation", is("1234567GGGG")));
}

    @Test
    public void getcsvOfTransaction() throws Exception{

        List<OutputTransactions> transactions = new ArrayList<OutputTransactions>();
        OutputTransactions outputTransactions = new OutputTransactions();
        outputTransactions.setTransactionAmount(BigDecimal.valueOf(10));
        outputTransactions.setProductInformation("ASDFG123456");
        outputTransactions.setClientInformation("1234567GGGG");
        transactions.add(outputTransactions);
        given(transactionService.createReportByDate("2010-10-10")).willReturn(transactions);
        mvc.perform(MockMvcRequestBuilders.get("/generatecsvreport/2010-10-10")
                .contentType("text/csv"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/csv"));
          }


}
