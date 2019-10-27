package com.assessment.service;

import com.assessment.beans.OutputTransactions;
import com.assessment.beans.ResultTransactions;
import com.assessment.dao.TransactionDao;
import com.assessment.transformer.RecordTransformer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Matchers.any;

@RunWith(SpringJUnit4ClassRunner.class)
public class TransactionServiceTest {

    @InjectMocks
    TransactionService transactionService;

    @Mock
    private TransactionDao transactionDao;

    @Mock
    private RecordTransformer transformMessageToDomain;

    private List<OutputTransactions> transactionList;

    private List<ResultTransactions> resulTransactionList;

    private ResultTransactions resultTransaction;

    @Before
    public void setup () {

        transactionList = new ArrayList<OutputTransactions>();
        OutputTransactions outPutTransaction = new OutputTransactions();
        outPutTransaction.setClientInformation("123456789ASDFGH");
        outPutTransaction.setProductInformation("43333FDSS");
        outPutTransaction.setTransactionAmount(BigDecimal.valueOf(10));
        outPutTransaction.setTransactionDate("20101010");
        transactionList.add(outPutTransaction);

        resulTransactionList = new ArrayList<ResultTransactions>();
        ResultTransactions resultTransaction = new ResultTransactions();
        resultTransaction.setSubAccountNumber("232332323");
        resultTransaction.setAccountNumber("123456");
        resultTransaction.setClientNumber("321");
        resultTransaction.setClientType("CL");
        resultTransaction.setExchangeCode("DFG");
        resultTransaction.setExpirationDate("20100909");
        resultTransaction.setProductGroupCode("HGF");
        resultTransaction.setSymbol("TY");
        resultTransaction.setTotalTransactionAmount(BigDecimal.valueOf(12345));
        resulTransactionList.add(resultTransaction);

    }

    @Test
    public void testCreateReportByDate () throws Exception{
        Mockito.when(transactionDao.getTransactionByDate(anyString())).thenReturn(resulTransactionList);
        Mockito.when(transformMessageToDomain.transformObjectToResult(any())).thenReturn("CL  123400020001SGX FUNK    20100910123456789920100819");
        List<OutputTransactions> outPutTransactionLis = transactionService.createReportByDate("20101010");
        Assert.assertNotNull(outPutTransactionLis);
        Assert.assertEquals(1,outPutTransactionLis.size() );
        Assert.assertEquals("CL  123400020001", outPutTransactionLis.get(0).getClientInformation());
        Assert.assertEquals("SGX FUNK    20100910", outPutTransactionLis.get(0).getProductInformation());
        Assert.assertEquals(BigDecimal.valueOf(123456789), outPutTransactionLis.get(0).getTransactionAmount());
    }

}
