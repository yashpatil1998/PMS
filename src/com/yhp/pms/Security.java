package com.yhp.pms;

import java.util.*;

public class Security {

	private List<Transaction> transactionList = new ArrayList<Transaction>();
	private List<Stock> stockList = new ArrayList<Stock>();
	private List<Account> accountList = new ArrayList<Account>();
	private String type;
	private int roi;

	public void addTransaction(long id, int amount, int quantity, String type) {
		transactionList.add(new Transaction(id, amount, quantity));
		if (type == "Stock") {
			stockList.add(new Stock(1, 150, "IBM"));

		} else {
			accountList.add(new Account("YHP", 2016120036, "SBI", 100));
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
		if(type == "Stock") {
			//set ROI according to formula
		}
		else {
			//ROI = constant for a Bank
		}
	}
	
	
	

}
