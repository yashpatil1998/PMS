package com.yhp.pms;

import java.util.*;

public class MainClass {
	
	static String uName;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to PMS ");
		Map<String, User> mapUser = new LinkedHashMap<String, User>();
		int choice = 0;
		do {

			System.out.println("Enter choice :");
			System.out.println("1. New User");
			System.out.println("2. Edit User Details");
			System.out.println("3. See User Details");
			System.out.println("0. Exit");
			
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter user name :");
				uName = sc.next();
				mapUser.put(uName, new User(uName, (int) Math.random(), 0));
				System.out.println("New User Created ");
				break;
			case 3:
				System.out.println("Enter user name :");
				uName = sc.next();
				if(mapUser.get(uName) != null)
				System.out.println(mapUser.get(uName));
				else
					System.out.println("No user found");
				break;
			default:
				System.out.println("Exiting ... ");
				break;
			}

		} while (choice != 0);

	}

}
