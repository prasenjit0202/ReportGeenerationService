package com.assessment.transformer;

import com.assessment.beans.ResultTransactions;
import com.assessment.beans.Transaction;
import com.assessment.entities.TransactionEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionConverter {

    static String convertDateFormat(String dateinString) {
        return dateinString.substring(0, 4) + "-" + dateinString.substring(4, 6) + "-" + dateinString.substring(6, 8);
    }

    public TransactionEntity dtoToEntity(Transaction transactionDto) {

        return new TransactionEntity(transactionDto.getClientType(),
                transactionDto.getClientNumber(),
                transactionDto.getAccountNumber(),
                transactionDto.getSubAccountNumber(),
                transactionDto.getExchangeCode(),
                transactionDto.getProductGroupCode(),
                transactionDto.getSymbol(),
                transactionDto.getExpirationDate(),
                transactionDto.getQuantityLong(),
                transactionDto.getQuantityShort(),
                LocalDate.parse(convertDateFormat(transactionDto.getTransactionDate())));
    }

    public List<ResultTransactions> entityToDto(List<TransactionEntity> transactionEntity) {

        List<ResultTransactions> transactionList = new ArrayList<>();
        transactionEntity.forEach(s -> {
            ResultTransactions transactionDto = new ResultTransactions();
            transactionDto.setAccountNumber(s.getAccountNumber());
            transactionDto.setClientNumber(s.getClientNumber());
            transactionDto.setClientType(s.getClientType());
            transactionDto.setExchangeCode(s.getExchangeCode());
            transactionDto.setExpirationDate(s.getExpirationDate());
            transactionDto.setProductGroupCode(s.getProductGroupCode());
            transactionDto.setSymbol(s.getSymbol());
            transactionList.add(transactionDto);
        });

        return transactionList;
    }

    public List<ResultTransactions> entityObjectArrayToDto(List<Object[]> transactionEntity) {

        List<ResultTransactions> transactionList = new ArrayList<>();
        transactionEntity.stream().forEach(s -> {
            ResultTransactions transactionDto = new ResultTransactions();
            transactionDto.setAccountNumber((String) s[2]);
            transactionDto.setSubAccountNumber((String) s[3]);
            transactionDto.setClientNumber((String) s[1]);
            transactionDto.setClientType((String) s[0]);
            transactionDto.setExchangeCode((String) s[4]);
            transactionDto.setExpirationDate((String) s[7]);
            transactionDto.setProductGroupCode((String) s[5]);
            transactionDto.setSymbol((String) s[6]);
            transactionDto.setTotalTransactionAmount((BigDecimal) s[8]);
            DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            String strDate = dateFormat.format(s[9]);
            transactionDto.setTransactionDate(strDate);
            transactionList.add(transactionDto);
        });

        return transactionList;
    }
}