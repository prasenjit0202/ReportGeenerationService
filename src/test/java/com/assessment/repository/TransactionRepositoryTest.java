package com.assessment.repository;

import com.assessment.entities.TransactionEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TransactionRepositoryTest {

        @Autowired
        private TestEntityManager entityManager;

        @Autowired
        private TransactionRepository transactionRepository;

    @Test
    public void whenFindAll_thenReturnTransactions() {
        TransactionEntity transactionEntity = new TransactionEntity("FL", "12345", "23456", "65432", "765", "HJ", "DK", "20101009", (long) 5, (long) 2, LocalDate.of(2010, 10, 9));
        entityManager.persist(transactionEntity);
        entityManager.flush();

        List<TransactionEntity> transaction = transactionRepository.findAll();

        Assert.assertEquals(transaction.get(0).getAccountNumber(),transactionEntity.getAccountNumber());
        Assert.assertEquals(transaction.get(0).getClientNumber(),transactionEntity.getClientNumber());

    }


    @Test
    public void whenFindbyDate_thenReturnTransactions() {
        TransactionEntity transactionEntity = new TransactionEntity("FL", "12345", "23456", "65432", "765", "HJ", "DK", "20101009", (long) 5, (long) 2, LocalDate.of(2010, 10, 9));
        entityManager.persist(transactionEntity);
        entityManager.flush();

        List<Object[]> transaction = transactionRepository.findTransactionsByDate(LocalDate.of(2010, 10, 9));
        Assert.assertEquals(1, transaction.size());
        Assert.assertEquals(transaction.get(0)[0],transactionEntity.getClientType());
        Assert.assertEquals(transaction.get(0)[1],transactionEntity.getClientNumber());

    }

}
