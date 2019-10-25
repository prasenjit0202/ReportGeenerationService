package com.assessment.dao;

import com.assessment.beans.ResultTransactions;
import com.assessment.beans.Transaction;
import com.assessment.entities.TransactionEntity;
import com.assessment.repository.TransactionRepository;
import com.assessment.transformer.TransactionConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionDaoImpl implements TransactionDao {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    TransactionConverter transactionConverter;

    @Override
    public List<ResultTransactions> getTransactionByDate(String date) {
       return transactionConverter.entityObjectArrayToDto(transactionRepository.findTransactionsByDate(LocalDate.parse(date)));
    }

    @Override
    public void saveTransaction(Transaction transaction) {
        transactionRepository.save(transactionConverter.dtoToEntity(transaction));

    }

    @Override
    public List<ResultTransactions> getAllTransaction() {
        return transactionConverter.entityToDto(transactionRepository.findAll());
    }
}