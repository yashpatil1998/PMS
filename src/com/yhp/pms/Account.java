package com.yhp.pms;

public class Account {

	private String accountName;
	private int accountId;
	private String bankName;
	private int balance;

	public Account(String accountName, int accountId, String bankName,
			int balance) {
		this.accountName = accountName;
		this.accountId = accountId;
		this.bankName = bankName;
		this.balance = balance;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accountName=" + accountName + ", accountId="
				+ accountId + ", bankName=" + bankName + ", balance=" + balance
				+ "]";
	}

}
