package com.assessment.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "transactionentity")
public class TransactionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "id")
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "clienttype")
    private String clientType;
    @Column(name = "clientnumber")
    private String clientNumber;
    @Column(name = "accountnumber")
    private String accountNumber;
    @Column(name = "subaccountnumber")
    private String subAccountNumber;
    @Column(name = "exchangecode")
    private String exchangeCode;
    @Column(name = "productgroupcode")
    private String productGroupCode;
    @Column(name = "symbol")
    private String symbol;
    @Column(name = "expirationdate")
    private String expirationDate;
    @Column(name = "quantitylong")
    private Long quantityLong;
    @Column(name = "quantityshort")
    private Long quantityShort;
    @Column(name = "transactiondate")
    private LocalDate transactionDate;

    public TransactionEntity() {
    }

    public TransactionEntity(String clientType, String clientNumber, String accountNumber, String subAccountNumber, String exchangeCode, String productGroupCode, String symbol, String expirationDate, Long quantityLong, Long quantityShort, LocalDate transactionDate) {
        this.clientType = clientType;
        this.clientNumber = clientNumber;
        this.accountNumber = accountNumber;
        this.subAccountNumber = subAccountNumber;
        this.exchangeCode = exchangeCode;
        this.productGroupCode = productGroupCode;
        this.symbol = symbol;
        this.expirationDate = expirationDate;
        this.quantityLong = quantityLong;
        this.quantityShort = quantityShort;
        this.transactionDate = transactionDate;

    }

    public String getClientType() {
        return clientType;
    }

    public String getClientNumber() {
        return clientNumber;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getSubAccountNumber() {
        return subAccountNumber;
    }

    public String getExchangeCode() {
        return exchangeCode;
    }

    public String getProductGroupCode() {
        return productGroupCode;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public Long getQuantityLong() {
        return quantityLong;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public Long getQuantityShort() {
        return quantityShort;
    }

}
