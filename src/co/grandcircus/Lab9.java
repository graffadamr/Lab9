package co.grandcircus;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lab9 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to Adam's Market!");
		System.out.println();
		double sum = 0;
		String contQuest = "";

		Map<String, Double> items = new HashMap<>();
		items.put("Mushrooms", 3.55);
		items.put("Olives", 1.51);
		items.put("Raspberries", 6.88);
		items.put("Avocados", 2.23);
		items.put("Spinach", 3.83);
		items.put("Kiwis", 2.18);
		items.put("Dates", 5.51);
		items.put("Apples", 1.62);

		Map<String, Double> totals = new HashMap<>();
		

		System.out.printf("%-14s %s\n", "Items", "Price");
		for (String key : items.keySet()) {
			System.out.printf("%-14s $%.2f\n", key, items.get(key));

			
		}
		do {
			System.out.println();
			System.out.print("What item would you like to order? ");
			String userChoice = scan.next();
			System.out.println();
			System.out.println();

			if (items.containsKey(userChoice)) {
				boolean alreadyOrdered = totals.containsKey(userChoice);

				if (alreadyOrdered) {
					double amount = totals.get(userChoice);
					amount += 1;
					totals.put(userChoice, amount);
					sum = sum + items.get(userChoice);
					System.out.println("Would you like to try anything else? y/n: ");
					contQuest = scan.next();
				} else {
					totals.put(userChoice, 1.0);
					sum = sum + items.get(userChoice);
					System.out.println("Would you like to try anything else? (y/n): ");
					contQuest = scan.next();
				}
			} else {
				System.out.println("Sorry, we don't have those. Please try again.");
			}
		} while (contQuest.equalsIgnoreCase("y"));

		System.out.println("Thanks for your order!");
		System.out.println("Here's what you got:");
		for (String itemName : totals.keySet()) {
			double quantity = totals.get(itemName);
			for (int i = 0; i < quantity; i++) {
				System.out.printf("%-14s $%.2f\n", itemName, items.get(itemName));
			}
		}
		System.out.printf("Average price per item in order was $%.2f", average(totals, sum));
		scan.close();
	}
	
		public static Double average(Map<String, Double> totals, double sum) {
		double totalItems = 0;
		for (String itemName : totals.keySet()) {
			double quantityTotal = totals.get(itemName);
					totalItems = totalItems + quantityTotal;
		}
		return sum / totalItems; 
		
		
	}
}
