package com.assessment.beans;

import java.math.BigDecimal;

public class ResultTransactions {

    private String clientType;
    private String clientNumber;
    private String accountNumber;
    private String subAccountNumber;
    private String exchangeCode;
    private String productGroupCode;
    private String symbol;
    private String expirationDate;
    private String transactionDate;
    private BigDecimal totalTransactionAmount;

    public BigDecimal getTotalTransactionAmount() {
        return totalTransactionAmount;
    }

    public void setTotalTransactionAmount(BigDecimal totalTransactionAmount) {
        this.totalTransactionAmount = totalTransactionAmount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "clientType='" + clientType + '\'' +
                ", clientNumber='" + clientNumber + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", subAccountNumber='" + subAccountNumber + '\'' +
                ", exchangeCode='" + exchangeCode + '\'' +
                ", productGroupCode='" + productGroupCode + '\'' +
                ", symbol='" + symbol + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", transactionDate=" + transactionDate +
                '}';
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(String clientNumber) {
        this.clientNumber = clientNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getSubAccountNumber() {
        return subAccountNumber;
    }

    public void setSubAccountNumber(String subAccountNumber) {
        this.subAccountNumber = subAccountNumber;
    }

    public String getExchangeCode() {
        return exchangeCode;
    }

    public void setExchangeCode(String exchangeCode) {
        this.exchangeCode = exchangeCode;
    }

    public String getProductGroupCode() {
        return productGroupCode;
    }

    public void setProductGroupCode(String productGroupCode) {
        this.productGroupCode = productGroupCode;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

}
