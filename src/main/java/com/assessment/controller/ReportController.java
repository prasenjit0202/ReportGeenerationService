package com.assessment.controller;

import com.assessment.beans.ResultTransactions;
import com.assessment.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@Slf4j
public class ReportController {

    @Autowired
    TransactionService transactionService;

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @GetMapping("/generatejsonreport/{reportDate}")
    public @ResponseBody List<ResultTransactions> generateJsonReport(@PathVariable String reportDate) {
    log.info("Received generateReport request for Date " + reportDate);
        List<ResultTransactions> transactions=null;
    try {
        //  List<ResultTransactions> transactions =   transactionService.getTransaction();
        transactions = transactionService.getTransactionDetailsByDate(reportDate);
        log.info("Report Generated for Date ", reportDate);
    }
    catch(Exception ex) {
        log.error("Exception while processing generatejsonReport" + ex.getMessage());
        ex.printStackTrace();
    }
    return transactions;
    }

    @GetMapping("/generateallreports")
    public @ResponseBody List<ResultTransactions> generateReport() {
     //   log.info("Received generateReport request for Date ", reportDate);
        List<ResultTransactions> transactions=null;
        try {
            transactions =   transactionService.getTransaction();
          //  transactions = transactionService.getTransactionDetailsByDate(reportDate);
           // log.info("Report Generated for Date ", reportDate);
        }
        catch(Exception ex) {
            log.error("Exception while processing generatejsonReport" + ex.getMessage());
            ex.printStackTrace();
        }
        return transactions;
    }

    @GetMapping("/generatecsvreport/{reportDate}")
    public void generatecsvReport(HttpServletResponse response, @PathVariable String reportDate) {
        log.info("Received generatecsvReport for date "+ reportDate);
        try {
            List<ResultTransactions> transactions = transactionService.getTransactionDetailsByDate(reportDate);

            response.setContentType("text/csv");
            ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
                    CsvPreference.STANDARD_PREFERENCE);

            String[] header = {"clientType", "clientNumber", "accountNumber", "subAccountNumber",
                    "exchangeCode", "productGroupCode", "symbol", "expirationDate", "totalTransactionAmount", "transactionDate"};

            csvWriter.writeHeader(header);

            for (ResultTransactions singleTransaction : transactions) {
                csvWriter.write(singleTransaction, header);
            }

            csvWriter.close();
            log.info("CSV Report generated");
        }
        catch(Exception ex) {
            log.error("Exception while processing generateCSVReport" + ex.getMessage());
            ex.printStackTrace();
        }
    }

}
