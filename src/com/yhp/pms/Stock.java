package com.yhp.pms;

public class Stock {

	private int stockId;
	private int currentPrice;
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

	public int getCurrentPrice() {
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
