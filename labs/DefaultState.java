package Lab;


import java.io.IOException;

import exercises.two.AuctionService;


public class DefaultState implements Event{

	AuctionService as;
	public DefaultState(AuctionService as){
		this.as = as;
	}
	
	
	@Override
	public void show() {
		System.out.println("New User, would you like to log in?(Hit Enter to decline)");

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
		if(input == null || input.equals("")){
			
			return null;
		}
		else{
			
			return new UserHomeState(as, input);
		}
	}
}
