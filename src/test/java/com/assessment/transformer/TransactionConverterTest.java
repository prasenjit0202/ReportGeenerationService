package com.assessment.transformer;

import com.assessment.beans.ResultTransactions;
import com.assessment.beans.Transaction;
import com.assessment.entities.TransactionEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TransactionConverterTest {


    TransactionConverter transactionConverter;

    List<TransactionEntity> transactionEntityList;

    @Before
    public void setup() {
        transactionConverter = new TransactionConverter();
    }

    @Test
    public void testDtoToEntity() {
        Transaction transactionDto = new Transaction();
        transactionDto.setTransactionDate("20100819");
        transactionDto.setSymbol("FU");
        transactionDto.setQuantityLong(11);
        transactionDto.setQuantityShort(1);
        transactionDto.setProductGroupCode("MK");
        transactionDto.setExpirationDate("20101010");
        transactionDto.setExchangeCode("CME");
        transactionDto.setClientType("CL");
        transactionDto.setClientNumber("1234");
        transactionDto.setAccountNumber("34567");
        transactionDto.setSubAccountNumber("1212");
        TransactionEntity transactionEntity = transactionConverter.dtoToEntity(transactionDto);
        Assert.assertNotNull(transactionEntity);
        Assert.assertEquals(LocalDate.of(2010,8, 19), transactionEntity.getTransactionDate());
        Assert.assertEquals("FU", transactionEntity.getSymbol());
        Assert.assertEquals("CL", transactionEntity.getClientType());

    }

    @Test
    public void testEntityToDto() {
        List<TransactionEntity> transactionEntityList = new ArrayList<TransactionEntity>();

        TransactionEntity transactionEntity = new TransactionEntity("FL", "12345", "23456", "65432", "765", "HJ", "DK", "20101009", (long) 5, (long) 2, LocalDate.of(2010, 10, 9));
        transactionEntityList.add(transactionEntity);
        List<ResultTransactions> resultTransactions = transactionConverter.entityToDto(transactionEntityList);
        Assert.assertNotNull(resultTransactions);
        Assert.assertEquals(1, resultTransactions.size());
    }

    @Test
    public void testEntityArrayToDto () {

        Object[] transactionEntity = {"FL", "12345", "23456", "65432", "765", "HJ", "DK", "20101009",  BigDecimal.valueOf(5) , BigDecimal.valueOf(2), LocalDate.of(2010, 10, 9)};
        List<Object[]> transactionEntityList = new ArrayList<Object[]>();
        transactionEntityList.add(transactionEntity);
        List<ResultTransactions> resultTransactions = transactionConverter.entityObjectArrayToDto(transactionEntityList);
        Assert.assertNotNull(resultTransactions);
        Assert.assertEquals(1, resultTransactions.size());
    }
}