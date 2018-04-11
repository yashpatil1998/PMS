package com.yhp.pms;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Stock {

	private int stockId;
	private float currentPriceClose;
	private String stockName;
	private int sQuant = 0;
	private float ROI = 0.0f;
	private int buysell = 1;
	private float totalInvestment = 0.0f;
	
	
	
	private List<Transaction> transactionList = new ArrayList<Transaction>();
	

	@Override
	public String toString() {
		return "Stock [currentPriceClose=" + currentPriceClose + ", stockName="
				+ stockName + ", sQuant=" + sQuant + ", transactionList="
				+ transactionList + "]";
	}
	

	public float getTotalInvestment() {
		return totalInvestment;
	}


	public void setTotalInvestment() {
		for (Transaction t : transactionList) {
			this.totalInvestment += t.getTransactionAmount() * this.buysell;
		}
	}


	public int getsQuant() {
		return sQuant;
	}

	public float getROI() {
		return ROI;
	}

	public void setROI(float rOI) {
		ROI = rOI;
	}

	public void setsQuant(int sQuant, int buysell) {
		this.sQuant += sQuant * buysell;
	}

	

	public Stock(String stockName) {
		this.stockName = stockName;
	}

	public void addTransaction(float amount, int quantity, int bs) {

		Transaction transaction = new Transaction(transactionList.size(),
				amount, quantity, bs);
		transactionList.add(transaction);

	}

	public List<Transaction> getTransactionList() {
		return transactionList;
	}

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	

	public float getCurrentPriceClose(Scanner sc, boolean currentP, String sSym)
			throws IOException {
		String stockPriceClose = "0.0000";
		String timeStamp;
		if (currentP == true)
			timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar
					.getInstance().getTime());
		else {
			System.out.println("Enter year yyyy");
			int y = sc.nextInt();
			System.out.println("Enter month mm");
			String m = sc.next();
			System.out.println("Enter day dd");
			String d = sc.next();
			timeStamp = y + "-"+ m +"-"+ d;
		}
		String stockSymbol = sSym;
		System.out.println("Connecting to AlphaVantage...");
		String link = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol="
				+ stockSymbol + "&outputsize=full&apikey=17HLSDZ8O8VT0GL0.json";
		URL url = new URL(link);
		URLConnection urlConn = url.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				urlConn.getInputStream()));
		System.out.println("Connected to AlphaVantage");
		String line1 = br.readLine();
		int startOpen = 0;
		int choice = 1;
		switch (choice) {
		case 1:
			while (line1 != null) {
				while (line1.contains(timeStamp) == true) {

					while (line1.contains("4. close") == false) {
						line1 = br.readLine();

						if (line1.contains("4. close") == true) {
							startOpen = line1.indexOf(".",
									line1.indexOf(".") + 1);
							stockPriceClose = line1.substring(startOpen - 2,
									startOpen + 5);
							System.out.println("Check Open");
							break;
						}

					}
				}
				line1 = br.readLine();
			}
			break;
		}
		System.out.println("Price of 1 Stock : " + stockPriceClose);
		// System.out.println(stockPriceClose);
		this.currentPriceClose = Float.parseFloat(stockPriceClose);
		return currentPriceClose;
	}

	public void setCurrentPrice(int currentPrice) {
		this.currentPriceClose = currentPrice;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

}
