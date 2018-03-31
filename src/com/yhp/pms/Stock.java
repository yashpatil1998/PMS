package com.yhp.pms;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Stock {

	private int stockId;
	private float currentPriceOpen;
	private float currentPriceClose;
	private String stockName;

	public Stock(int stockId, int currentPriceOpen, String stockName) {
		this.stockId = stockId;
		this.currentPriceOpen = currentPriceOpen;
		this.stockName = stockName;
	}

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public float getCurrentPriceOpen(Scanner sc) throws IOException {
		String stockPriceOpen = "0.0000";
		String stockPriceClose = "0.0000";
//		String timeStamp = new SimpleDateFormat("yyyy-MM-dd")
//				.format(Calendar.getInstance().getTime());
		System.out.println("Enter year yyyy");
		int y = sc.nextInt();
		System.out.println("Enter month mm");
		int m = sc.nextInt();
		System.out.println("Enter day dd");
		int d = sc.nextInt();
		System.out.println("Enter Stock Symbol");
		String stockSymbol = sc.next();
		String link = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol="
				+ stockSymbol + "&outputsize=full&apikey=17HLSDZ8O8VT0GL0.json";
		URL url = new URL(link);
		URLConnection urlConn = url.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				urlConn.getInputStream()));
		String line1 = br.readLine();
		int startOpen = 0;
		int choice = 1;
		switch (choice) {
		case 1:
			while (line1 != null) {
				while (line1.contains(y + "-" + m + "-" + d) == true) {

					while (line1.contains("1. open") == false) {
						line1 = br.readLine();

						if (line1.contains("1. open") == true) {
							startOpen = line1.indexOf(".",
									line1.indexOf(".") + 1);
							stockPriceOpen = line1.substring(startOpen - 2,
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
		System.out.println(stockPriceOpen);
		System.out.println(stockPriceClose);
		this.currentPriceOpen = Float.parseFloat(stockPriceOpen);
		return currentPriceOpen;
	}

	public void setCurrentPrice(int currentPrice) {
		this.currentPriceOpen = currentPrice;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", currentPrice=" + currentPriceOpen
				+ ", stockName=" + stockName + "]";
	}

}
