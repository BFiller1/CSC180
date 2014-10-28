package labs.two;

import java.io.IOException;

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
			
		}
		if(input == null || input.equals("")){
			
			return new DefaultState(as);
			
		}
		else{
			
			return new UserHomeState(as, input);
		}
	}
}
