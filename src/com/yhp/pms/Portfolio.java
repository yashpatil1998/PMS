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
		return "Portfolio [portfolioName=" + portfolioName + "]";
	}

	public void addSecurity(String type) {

		securityList.add(new Security(type));
		Security security = securityList.get(securityList.size() - 1);
		security.addTransaction((long)Math.random(), 200, 3, "Stock");

	}

	public int calculateNetWorth() {
		return 3;
	}

}
