package com.yhp.pms;

import java.util.*;

public class Portfolio {

	private List<Security> securityList = new ArrayList<Security>();
	private String portfolioName;

	public String getPortfolioName() {
		return portfolioName;
	}

	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}

	public Portfolio(String portfolioName) {
		this.portfolioName = portfolioName;
	}


	@Override
	public String toString() {
		return "Portfolio [securityList=" + securityList + ", portfolioName="
				+ portfolioName + "]";
	}

	public void addSecurity(String type, Scanner sc) {

		securityList.add(new Security(type));
		Security security = securityList.get(securityList.size() - 1);
		if (type.equalsIgnoreCase("Stock")) {
			System.out.println("Enter stock name (Symbol) :");
			String sName = sc.next();
			System.out.println("Enter quantity :");
			int sQuant = sc.nextInt();
			System.out.println("Enter amount");
			int sAmount = sc.nextInt();
			security.addTransaction(security.getTransactionList().size(),
					sAmount, sQuant, type, sName, "");
		} else {
			System.out.println("Enter Bank name :");
			String bName = sc.next();
			System.out.println("Enter Account Name :");
			String aName = sc.next();
			System.out.println("Enter account balance :");
			int aBalance = sc.nextInt();
			security.addTransaction(security.getTransactionList().size(),
					aBalance, 0, type, aName, bName);
		}

	}

	public void deleteSecurity(Scanner sc) {
			System.out.println("Enter security ID :");
			int sId = sc.nextInt();
			this.securityList.remove(sId);
	}
	
	public void viewSecurity(int sId) {
		System.out.println(this.securityList.get(sId));
	}

	public int calculateNetWorth() {
		return 3;
	}

}
