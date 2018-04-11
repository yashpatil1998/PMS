package com.yhp.pms;

public class Transaction {

	private long transationId;
	private float transactionAmount;
	private int quantity;
	private int buysell;
	
	private float netInvestment = 0.0f;

	public float getNetInvestment() {
		return netInvestment;
	}
	
	public int getBuysell() {
		return buysell;
	}



	public void setBuysell(int buysell) {
		this.buysell = buysell;
	}



	public void setNetInvestment() {
		this.netInvestment += (this.buysell * this.transactionAmount);
	}

	public void setTransactionAmount(float transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Transaction(long id, float sAmount, int quantity, int buysell) {
		this.transationId = id;
		this.transactionAmount = sAmount;
		this.quantity = quantity;
		this.buysell = buysell;
	}

	public long getTransationId() {
		return transationId;
	}

	public void setTransationId(long transationId) {
		this.transationId = transationId;
	}

	public float getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public int getQuantity() {
		return quantity*buysell;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Transaction [transationId=" + transationId
				+ ", transactionAmount=" + transactionAmount + ", quantity="
				+ quantity + "]";
	}

}
