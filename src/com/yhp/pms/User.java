package com.yhp.pms;

import java.util.*;

public class User {
	private Map<String, Portfolio> mapPortfolio = new LinkedHashMap<String, Portfolio>();
	private String userName;
	private int userId;
	private long netWorth;

	public void renamePortfolio(String oldName, String newName) {

		Portfolio portfolio = mapPortfolio.get(oldName);
		portfolio.setPortfolioName(newName);

	}

	public void deletePortfolio(String pName) {
		mapPortfolio.remove(pName);
	}

}
