package labs.three;

import java.io.IOException;
import java.util.Stack;


public class SearchResultsState implements Event{
	String name;
	AuctionService as;
	String input;
	TableRowAuctionConverter trac = new TableRowAuctionConverter();
	public SearchResultsState(AuctionService as, String name, String input){
		this.name = name;
		this.as = as;
		this.input = input;
		
	}

	@Override
	public void show() {
		System.out.println(name + ", here are your search results:");
		
		Auction[] auctionResults = as.search(input);
		for(Auction auc : auctionResults){
			try{
				System.out.println(auc.toString());
			}
			catch(Exception e){
				System.out.println("No results match");
			}
		}
		System.out.println("Enter the item id to increase the bid by $1.  Otherwise, enter another search: (hit enter to go back to home page)");
	}

	@Override
	public Event next() {
		try {
			input = br.readLine();
			
		} catch (IOException e1) {
			
		}
		if(input == null || input.equals(""))
		{
			
			return new UserHomeState(as, name);
		}
		
		else{
			try{
				as.bid(name, Integer.parseInt(input));
			}
			catch(Exception e){
//				System.out.println("something is wrong");
				//return new SearchResultsState(as, name, input);
			}
			return new UserHomeState(as, name);
		}
	}
}
