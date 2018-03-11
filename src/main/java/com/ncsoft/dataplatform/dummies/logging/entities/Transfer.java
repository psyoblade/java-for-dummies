package com.ncsoft.dataplatform.dummies.logging.entities;

public class Transfer {
	private Integer transactionId;
	private String sender;
	private Long amount;

	public Transfer(Integer transactionId, String sender, long amount) {
		this.transactionId = transactionId;
		this.sender = sender;
		this.amount = amount;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public String getSender() {
		return sender;
	}

	public Long getAmount() {
		return amount;
	}
}
