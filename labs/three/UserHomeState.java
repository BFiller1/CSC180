
package labs.three;

import java.io.IOException;


public class UserHomeState implements Event{

	String name;
	AuctionService as;
	
	public UserHomeState(AuctionService as, String name){
		this.name = name;
		this.as = as;
	}

	@Override
	public void show() {
		System.out.println(name + ", what would you like to search for? (Hit Enter to logout, Type ADD to add a new item to the auction)");

	}

	@Override
	public Event next() {
		String input = null;
		try {
			input = br.readLine();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		//alters state
		if(input == null || input.equals("")){
			return new DefaultState(as);
		}
		if(input.equalsIgnoreCase("add")){
			return new AuctionCreateState(name, as);
		}
		else{
			
			return new SearchResultsState(as, name, input);
		}
	}
}
