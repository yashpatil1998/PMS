package com.yhp.pms;

import java.util.*;

public class MainClass {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
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

						System.out.println("0. Logout");

						userChoice = sc.nextInt();

						switch (userChoice) {
						case 1:
							System.out.println("Enter portfolio name :");
							pName = sc.next();
							if (activeUser.getMapPortfolio().containsKey(pName) == true)
								System.out.println("Portfolio already exists");
							else {
								activeUser.addPortfolio(pName);
								System.out.println("New Portfolio created");
							}

							break;
						case 2:
							System.out.println("Enter Old Name:");
							String oldName = sc.next();
							if (activeUser.getMapPortfolio().containsKey(
									oldName) == true) {
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
							if (activeUser.getMapPortfolio().containsKey(pName) == true)
								System.out.println(activeUser.getMapPortfolio()
										.get(pName));
							break;
						default:
							System.out.println("Logging Out ... ");
							break;

						}

					}
				} while (userChoice != 0);
				System.out.println("Logged out");
				break;
			default:
				System.out.println("Exiting ... ");
				break;
			}

		} while (choice != 0);

	}

}