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
	
	public void addPortfolio() {

	}
	
	public void editUserDetails(Scanner scanner) {
		System.out.println("Enter \n1 to edit UserName\n");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Enter new UserName:");
			String newUserName = scanner.next();
			this.userName = newUserName;
			break;
		}
	}

}
