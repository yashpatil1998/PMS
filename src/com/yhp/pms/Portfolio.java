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

}
