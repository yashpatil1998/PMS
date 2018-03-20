package com.yhp.pms;

public class Transaction {

	private long transationId;
	private int transactionAmount;
	private int quantity;

	public Transaction(long transationId, int transactionAmount, int quantity) {
		this.transationId = transationId;
		this.transactionAmount = transactionAmount;
		this.quantity = quantity;
	}

	public long getTransationId() {
		return transationId;
	}

	public void setTransationId(long transationId) {
		this.transationId = transationId;
	}

	public int getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
