package labs.two;

import java.io.IOException;

public class AuctionCreateState implements Event {
//this will use the create statement
	String name;
	String description;
	int price = 1;
	int id = 4;
	String person;
	AuctionService as;
	InMemoryAuctionService imas = new InMemoryAuctionService();
	Auction newItem = new Auction(id, name, description, price);
	@Override
	public void show() {
		System.out.println("Type in the required information for a new auction item.");
		try {
			br.readLine();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("Name of product:");
		try {
			name = br.readLine();
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
			price = br.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		id++;
		imas.create(newItem);
	}

	@Override
	public Event next() {
		return new UserHomeState(as, person);
	}

}
