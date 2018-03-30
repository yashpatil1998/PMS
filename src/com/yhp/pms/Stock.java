package com.yhp.pms;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Stock {

	private int stockId;
	private float currentPrice;
	private String stockName;

	public Stock(int stockId, int currentPrice, String stockName) {
		this.stockId = stockId;
		this.currentPrice = currentPrice;
		this.stockName = stockName;
	}

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public float getCurrentPrice() throws IOException {
		String stockPrice = "0.0000";
//		String timeStamp = new SimpleDateFormat("yyyy-MM-dd")
//				.format(Calendar.getInstance().getTime());
//		System.out.println(timeStamp);
		String stockSymbol = "MSFT";
		String link = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol="
				+ stockSymbol + "&outputsize=full&apikey=17HLSDZ8O8VT0GL0.json";
		URL url = new URL(link);
		URLConnection urlConn = url.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				urlConn.getInputStream()));
		String line = br.readLine();
		int start = 0;
		while (line != null) {
			if (line.contains("1. open")) {
				start = line.indexOf(".", line.indexOf(".") + 1);
				stockPrice = line.substring(start - 2, start + 5);
				break;
			}
			
			line = br.readLine();
		}
		this.currentPrice = Float.parseFloat(stockPrice);
		return currentPrice;
	}

	public void setCurrentPrice(int currentPrice) {
		this.currentPrice = currentPrice;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", currentPrice=" + currentPrice
				+ ", stockName=" + stockName + "]";
	}

}
