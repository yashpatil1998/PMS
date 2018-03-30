package com.yhp.pms;

import java.util.*;

public class Security {

	private List<Transaction> transactionList = new ArrayList<Transaction>();
	private List<Stock> stockList = new ArrayList<Stock>();
	private List<Account> accountList = new ArrayList<Account>();
	private String type;
	private int roi;

	public Security(String type) {
		this.type = type;
	}

	public List<Transaction> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(List<Transaction> transactionList) {
		this.transactionList = transactionList;
	}

	public void addTransaction(int id, int amount, int quantity, String type, String name,String bName) {
		transactionList.add(new Transaction(id, amount, quantity));
		if (type == "Stock") {
			stockList.add(new Stock(this.stockList.size(), 150, name));
			Account temp = null;
			accountList.add(temp);

		} else {
			accountList.add(new Account(name, this.accountList.size(), bName, amount));
			Stock temp = null;
			stockList.add(temp);
		}
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getRoi() {
		return roi;
	}

	public void setRoi() {
		if (type == "Stock") {
			// set ROI according to formula
		} else {
			// ROI = constant for a Bank
		}
	}

	@Override
	public String toString() {
		return "Security [transactionList=" + transactionList + ", stockList="
				+ stockList + ", accountList=" + accountList + ", type=" + type
				+ ", roi=" + roi + "]";
	}

}
