package labs.five;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class AuctionCreateState implements Event {
	String name;
	String description;
	int price = 1;
	String productName;
	AuctionService as;
	int bids = 1;
	Date date;
	String creator;


	SimpleDateFormatConverter sdfc = new SimpleDateFormatConverter();
	
	AuctionCreateState(String name, AuctionService as){
		this.name = name;
		this.as = as;
	}
	
	@Override
	public void show() {
		
		Auction a = null;
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
		System.out.println("Input expiration date of item up for bid");
		try {
			String stringDate = br.readLine();
			date = sdfc.parse(stringDate);
//			stringDate.parse();
		} catch (Exception e) {
			
			Calendar c = Calendar.getInstance();
			c.add(Calendar.DAY_OF_YEAR, 7);
			date = c.getTime();
			
		}
//		try{

//		}
//		catch(Exception e){
//			
//			a.timeLeftInMillis();
//		}
		System.out.println("Enter total number of bids.");
		try{
			String stringToInt = br.readLine();
			bids = Integer.parseInt(stringToInt);
		}
		catch(Exception e){
			System.out.println("Not a valid number try again.");
		}
		int id = as.searches.size()+1;
		creator = name;
		a = new Auction(id, productName, description, price, bids, date, creator);
		as.create(a);
		System.out.println(name + ", " + productName + " has been added to the auction." + "\n");
	}

	@Override
	public Event next() {
		return new UserHomeState(as, name);
	}
}
