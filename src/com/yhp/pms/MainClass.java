package com.yhp.pms;

import java.io.IOException;
import java.util.*;

public class MainClass {

	public void openPortfolio(String pName, User activeUser, Scanner sc)
			throws IOException {

		int pChoice = 0;
		String stockSym;
		Portfolio activePortfolio = activeUser.getMapPortfolio().get(pName);
		do {
			System.out.println(pName + " opened");
			System.out.println("Enter choice :");
			System.out.println("1. Create new Security ");
			System.out.println("2. Add new Transaction to existing Security");
			System.out.println("3. Delete Security");
			System.out.println("4. View Existing Security Details");

			System.out.println("0. Exit Portfolio and go to User Operations");
			pChoice = sc.nextInt();
			switch (pChoice) {
			case 1:
				System.out.println("Following is the list of Stock Symbols and their corresponding Company names :");
				activePortfolio.getStockSymbol();
				System.out.println("Enter valid stock SYMBOL:");
				stockSym = sc.next();
				activePortfolio.addNewSecurity(stockSym, sc);
				System.out.println("New Security added");
				break;
			case 2:
				System.out.println("Following are existing securities:");
				activePortfolio.getExistingSecurities();
				System.out.println("Enter Stock Symbol :");
				stockSym = sc.next();
				Stock activeSecurity = activePortfolio.getMapStock()
						.get(stockSym);
				System.out.println("Enter quantity of stock :");
				int sQuant = sc.nextInt();
				System.out.println("Enter total amount :");
				float sAmt = sc.nextFloat();
				System.out.println("Enter whether bought(1) or sold(-1)");
				int bs = sc.nextInt();
				activeSecurity.setsQuant(sQuant,bs);
				activeSecurity.addTransaction(sAmt, sQuant, bs);
				break;
			case 3:
				System.out.println("Following are existing securities:");
				activePortfolio.getExistingSecurities();
				System.out.println("Enter valid stock SYMBOL:");
				stockSym = sc.next();
				activePortfolio.deleteSecurity(stockSym);
				break;

			case 4:
				System.out.println("Following are existing securities:");
				activePortfolio.getExistingSecurities();
				System.out.println("Enter Stock Symbol :");
				stockSym = sc.next();
				System.out.println(activePortfolio.getMapStock().get(stockSym));
				break;

			case 0:
				System.out.println("Exiting Active Portfolio...");
			}
		} while (pChoice != 0);

	}

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		MainClass obj = new MainClass();
		String uName, pName;
		System.out.println("Welcome to PMS ");
		System.out.println(UUID.randomUUID());
		Map<String, User> mapUser = new LinkedHashMap<String, User>();
		int choice = 0;
		do {

			System.out.println("Enter choice :");
			System.out.println("1. New User");
			System.out.println("2. Edit User Details");
			System.out.println("3. See User Details");
			System.out.println("4. Login as Existing User");
			System.out.println("0. Exit");

			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter user name :");
				uName = sc.next();
				if (mapUser.get(uName) == null) {
					mapUser.put(uName, new User(uName, mapUser.size(), 0));
					System.out.println("New User Created ");
				} else
					System.out.println("User name already exists");
				break;

			case 2:
				System.out.println("Enter user name :");
				uName = sc.next();
				User user = mapUser.get(uName);
				mapUser.remove(uName);
				user.editUserDetails(sc);
				mapUser.put(user.getUserName(), user);
				break;
			case 3:
				System.out.println("Enter user name :");
				uName = sc.next();
				if (mapUser.get(uName) != null)
					System.out.println(mapUser.get(uName));
				else
					System.out.println("No user found");
				break;
			case 4:
				System.out.println("Enter user name :");
				uName = sc.next();
				User activeUser = mapUser.get(uName);
				int userChoice = 0;
				do {
					if (mapUser.get(uName) != null) {
						System.out.println("Logged in as " + uName);
						System.out.println("Enter choice :");
						System.out.println("1. New Portfolio");
						System.out.println("2. Rename Portfolio:");
						System.out.println("3. See existing Portfolio details");
						System.out.println("4. Open a Portfolio");
						System.out.println("5. Calculate Net Worth");
						System.out.println("6. Calculate Return of Investment");

						System.out.println("0. Logout");

						userChoice = sc.nextInt();

						switch (userChoice) {
						case 1:
							System.out.println("Enter portfolio name :");
							pName = sc.next();
							if (activeUser.getMapPortfolio()
									.containsKey(pName) == true)
								System.out.println("Portfolio already exists");
							else {
								activeUser.addPortfolio(pName);
								System.out.println("New Portfolio created");
							}

							break;
						case 2:
							System.out.println("Enter Old Name:");
							String oldName = sc.next();
							if (activeUser.getMapPortfolio()
									.containsKey(oldName) == true) {
								System.out.println("Enter new name:");
								String newName = sc.next();
								activeUser.renamePortfolio(oldName, newName);
							} else
								System.out
										.println("Portfolio does not exist !");

							break;
						case 3:
							System.out.println("Enter portfolio name : ");
							pName = sc.next();
							if (activeUser.getMapPortfolio()
									.containsKey(pName) == true)
								System.out.println(activeUser.getMapPortfolio()
										.get(pName));
							break;
						case 4:
							System.out.println("Enter Portfolio Name:");
							pName = sc.next();
							if (activeUser.getMapPortfolio()
									.containsKey(pName) == true) {
								obj.openPortfolio(pName, activeUser, sc);
								System.out.println("Active Portfolio Exited");
							} else
								System.out.println("Portfolio does not exist");
							break;
						case 5:
							System.out.println("Enter the date on which to calculate Net Worth");
							for(Portfolio aPort : activeUser.getMapPortfolio().values()) {
								for(Stock aStock : aPort.getMapStock().values()) {
									aPort.setNetWorth(aPort.getNetWorth() + aStock.getCurrentPriceClose(sc, false, aStock.getStockName()) * aStock.getsQuant());									
								}
								System.out.println("Net worth of " + aPort.getPortfolioName() + " portfolio is : " +aPort.getNetWorth());
								activeUser.setNetWorth(activeUser.getNetWorth() + aPort.getNetWorth());
							}
							System.out.println("Net Worth of " + activeUser.getUserName() + " User is : " + activeUser.getNetWorth());
							break;
						case 6:
							System.out.println("Enter the date on which to calculate Return of Investment");
							
							for(Portfolio aPort : activeUser.getMapPortfolio().values()) {
								for(Stock aStock : aPort.getMapStock().values()) {
									float tIn = aStock.getTotalInvestment();
									System.out.println("Total investment in " + aStock.getStockName() + " : " + tIn);
									float p = 0.0f;
									float cP = aStock.getsQuant()*aStock.getCurrentPriceClose(sc, false, aStock.getStockName());
									System.out.println("Market Price is :" + cP);
									p = ((cP - tIn)*100/tIn);
									System.out.println(p);
									aStock.setROI(p);
									System.out.println("RoI of "+aStock.getStockName()+" is :"+aStock.getROI()+"%");
								}
							}
							break;
						case 0:
							System.out.println("Logging Out ... ");

						}

					}
				} while (userChoice != 0);
				System.out.println("Logged out");
				break;
			case 0:
				System.out.println("Exiting ... ");
			}

		} while (choice != 0);

	}

}
