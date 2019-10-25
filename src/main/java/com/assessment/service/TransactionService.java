package com.assessment.service;

import com.assessment.beans.ResultTransactions;
import com.assessment.beans.Transaction;
import com.assessment.dao.TransactionDao;
import com.assessment.transformer.TransformMessageToDomain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TransactionService {

    @Autowired
    private TransformMessageToDomain transformMessageToDomain;
    @Autowired
    private TransactionDao transactionDao;


    public void executeIncomingMessage(String message) throws Exception{
        Transaction transaction = transformMessageToDomain.transform(message);
        transactionDao.saveTransaction(transaction);
        log.info("Transaction saved " + transactionDao.getAllTransaction());
     //   log.info("Transaction saved " + transactionDao.getTransactionByDate("2010-08-20"));
    }

    public List<ResultTransactions> getTransaction() {
        return transactionDao.getAllTransaction();
    }

    public List<ResultTransactions> getTransactionDetailsByDate(String date) {
        List<ResultTransactions> transactions = transactionDao.getTransactionByDate(date);
        return transactions;
    }
}
