package com.assessment.beans;


import java.math.BigDecimal;

public class OutputTransactions {

    private String clientInformation;
    private String productInformation;
    private BigDecimal transactionAmount;
    private String transactionDate;

    public String getClientInformation() {
        return clientInformation;
    }

    public void setClientInformation(String clientInformation) {
        this.clientInformation = clientInformation;
    }

    public String getProductInformation() {
        return productInformation;
    }

    public void setProductInformation(String productInformation) {
        this.productInformation = productInformation;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

}
