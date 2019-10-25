package com.assessment.beans;

public class Transaction {

    private String clientType;
    private String clientNumber;
    private String accountNumber;
    private String subAccountNumber;
    private String exchangeCode;
    private String productGroupCode;
    private String symbol;
    private String expirationDate;
    private long quantityLong;
    private long quantityShort;
    private String transactionDate;

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
                ", quantityLong=" + quantityLong +
                ", quantityShort=" + quantityShort +
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

    public long getQuantityLong() {
        return quantityLong;
    }

    public void setQuantityLong(long quantityLong) {
        this.quantityLong = quantityLong;
    }

    public long getQuantityShort() {
        return quantityShort;
    }

    public void setQuantityShort(long quantityShort) {
        this.quantityShort = quantityShort;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }


}
