package com.yhp.pms;

import java.util.*;

public class User {
	private Map<String, Portfolio> mapPortfolio = new LinkedHashMap<String, Portfolio>();
	private String userName;
	private int userId;
	private long netWorth;

	@Override
	public String toString() {
		return "User [userName=" + userName + ", userId=" + userId
				+ ", netWorth=" + netWorth + "]";
	}

	public Map<String, Portfolio> getMapPortfolio() {
		return mapPortfolio;
	}

	public void setMapPortfolio(Map<String, Portfolio> mapPortfolio) {
		this.mapPortfolio = mapPortfolio;
	}

	public User(String userName, int userId, long netWorth) {
		this.userName = userName;
		this.userId = userId;
		this.netWorth = netWorth;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public long getNetWorth() {
		return netWorth;
	}

	public void setNetWorth(long netWorth) {
		this.netWorth = netWorth;
	}

	public void renamePortfolio(String oldName, String newName) {

		Portfolio portfolio = mapPortfolio.get(oldName);
		portfolio.setPortfolioName(newName);

	}

	public void deletePortfolio(String pName) {
		mapPortfolio.remove(pName);
	}

	public void addPortfolio(String name) {

		mapPortfolio.put(name, new Portfolio(name));

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
