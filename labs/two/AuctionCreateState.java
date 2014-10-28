package labs.two;

import java.io.IOException;
import java.util.Random;

public class AuctionCreateState implements Event {
//this will use the create statement
	Random rand = new Random();
	String name;
	String description;
	int price = 1;
	String productName;
	AuctionService as;
//	int id = as.searches.size()+1;
//	int id = 4;

	AuctionCreateState(String name, AuctionService as){
		this.name = name;
		this.as = as;

	}
	
	@Override
	public void show() {
		System.out.println(name + ", type in the required information for a new auction item." + "\n");

		System.out.println("Name of product:");
		try {
			productName = br.readLine();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("Description of product:");
		try {
			description = br.readLine();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("Price of product:");
		try {
			String stringToInt = br.readLine();
			price = Integer.parseInt(stringToInt);
			 
		} catch (Exception e) {
			System.out.println("The input wasn't a number or was out of bounds try again.");
		}
		int id = as.searches.size()+1;
		Auction a = new Auction(id, productName, description, price);
		as.create(a);
		System.out.println();
		System.out.println(productName + " has been added to the auction." + "\n");
	}

	@Override
	public Event next() {
		return new UserHomeState(as, name);
	}
}
