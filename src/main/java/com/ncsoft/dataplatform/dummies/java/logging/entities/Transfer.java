package com.ncsoft.dataplatform.dummies.java.logging.entities;

public class Transfer {
    private String transactionId;
    private String sender;
    private Long amount;

    public Transfer(int transactionId, String sender, long amount) {
        this.transactionId = new Integer(transactionId).toString();
        this.sender = sender;
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getSender() {
        return sender;
    }

    public Long getAmount() {
        return amount;
    }
}
