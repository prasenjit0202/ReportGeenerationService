package com.assessment.service;

import com.assessment.beans.OutputTransactions;
import com.assessment.beans.ResultTransactions;
import com.assessment.beans.Transaction;
import com.assessment.dao.TransactionDao;
import com.assessment.transformer.RecordTransformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TransactionService {

    @Autowired
    private RecordTransformer transformMessageToDomain;
    @Autowired
    private TransactionDao transactionDao;


    public void executeIncomingMessage(String message) throws Exception {
        Transaction transaction = transformMessageToDomain.transformRecordToObject(message);
        transactionDao.saveTransaction(transaction);
        log.info("Transaction saved ");
       }

    public List<ResultTransactions> getTransaction() {
        return transactionDao.getAllTransaction();
    }

    public List<OutputTransactions> createReportByDate(String date) throws Exception {
        List<ResultTransactions> transactions = transactionDao.getTransactionByDate(date);
        List<OutputTransactions> outTransactions = new ArrayList<OutputTransactions>();
        try {
            transactions.forEach(s -> {
                try {
                    outTransactions.add(convertToOutPutRows(s));
                } catch (Exception e) {
                    e.printStackTrace();

                }
            });
        } catch (Exception ex) {
            throw ex;
        }
        return outTransactions;
    }

    private OutputTransactions convertToOutPutRows(ResultTransactions resultTransac) throws Exception {
        OutputTransactions outputTransactions = new OutputTransactions();
        String record = transformMessageToDomain.transformObjectToResult(resultTransac);
        outputTransactions.setClientInformation(StringUtils.substring(record, 0, 16));
        outputTransactions.setProductInformation(StringUtils.substring(record, 16, 36));
        outputTransactions.setTransactionAmount(new BigDecimal(StringUtils.substring(record, 36, 45).trim()));
        outputTransactions.setTransactionDate(StringUtils.substring(record, 45, 54));
        return outputTransactions;


    }
}
