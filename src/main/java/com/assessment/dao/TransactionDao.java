package com.assessment.dao;


import com.assessment.beans.ResultTransactions;
import com.assessment.beans.Transaction;

import java.util.List;

public interface TransactionDao {

    List<ResultTransactions> getTransactionByDate(String date);

    void saveTransaction(Transaction trtansaction);

    List<ResultTransactions> getAllTransaction();

}
