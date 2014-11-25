
package labs.five;

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
		System.out.println(name + ", would you like to search for an item, create an item, or edit an existing item?  (Hit Enter to logout, Type ADD to add a new item to the auction)");
		System.out.println("Type in the corresponding number to select that entry.");
		System.out.println("1) search for an item.");
		System.out.println("2) create an item");
		System.out.println("3) edit/delete an existing item");

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
		if(input.equals("1")){
			System.out.println("What would you like to search for");
			try {
				input = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new SearchResultsState(as, name, input);
		}
		if(input.equals("2")){
			return new AuctionCreateState(name, as);
		}
		if(input.equals("3")){
			return new SearchResultsState(as, name, input);
		}

		else{
			return new UserHomeState(as, name);
		}
	}
}
