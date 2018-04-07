package com.yhp.pms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Portfolio {

	private String portfolioName;
	private Map<String, Stock> mapStock = new LinkedHashMap<String, Stock>();
	private float netWorth = 0.0f;
	
	
	
	public float getNetWorth() {
		return netWorth;
	}

	public void setNetWorth(float f) {
		this.netWorth = f;
	}

	public void getStockSymbol() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("StockSymbol.txt"));
		String read = br.readLine();
		while (read != null) {
			System.out.println(read);
			read = br.readLine();
		}
		br.close();
		
	}
	
	public void getExistingSecurities() {
		System.out.println(this.mapStock.keySet());
	}

	public String getPortfolioName() {
		return portfolioName;
	}

	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}

	public Portfolio(String portfolioName) {
		this.portfolioName = portfolioName;
	}

	public void addNewSecurity(String stockSymbol, Scanner sc) {

		Stock activeStock = new Stock(stockSymbol);
		mapStock.put(stockSymbol, activeStock);

	}

	public void deleteSecurity(String sym) {
		mapStock.remove(sym);
	}

	public Map<String, Stock> getMapStock() {
		return mapStock;
	}

	@Override
	public String toString() {
		return "Portfolio [portfolioName=" + portfolioName + ", mapStock="
				+ mapStock + "]";
	}
	
	

}
