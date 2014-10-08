package Lab;

import java.io.IOException;

import exercises.two.AuctionService;


public class UserHomeState implements Event{

	String name;
	AuctionService as;
	public UserHomeState(AuctionService as, String name){
		this.name = name;
		this.as = as;
	}

	@Override
	public void show() {
		System.out.println(name + ", what would you like to search for? (Hit Enter to logout)");

	}

	@Override
	public Event next() {
		String input = null;
		try {
			input = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//alters state
		if(input == null || input.equals("")){
			
			return null;
		}
		else{
			
			return new SearchResultsState(as, name, input);
		}
	}
}
