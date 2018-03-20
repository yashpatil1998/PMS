package com.yhp.pms;

import java.util.*;

public class Security {

	private List<Transaction> transactionList = new ArrayList<Transaction>();
	private String type;
	private int roi;

	public void addTransaction() {
		transactionList.add(new Transaction(123, 123, 123));
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
