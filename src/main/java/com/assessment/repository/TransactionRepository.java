package com.assessment.repository;

import com.assessment.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Integer> {

    @Query(value = "select clienttype,clientnumber,accountnumber,subaccountnumber,exchangecode,productgroupcode,symbol," +
            " expirationdate, sum(quantitylong) - sum(quantityshort) as totalTransactionAmount, transactiondate from  transactionentity \n" +
            " where transactiondate = :date group by clienttype,clientnumber,accountnumber,subaccountnumber,exchangecode,productgroupcode,symbol,\n" +
            "             expirationdate", nativeQuery = true)
    List<Object[]> findTransactionsByDate(@Param("date") LocalDate date);
}
