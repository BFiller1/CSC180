package Lab;

import java.io.IOException;

import exercises.two.Auction;
import exercises.two.AuctionService;

public class SearchResultsState implements Event{
	String name;
	AuctionService as;
	String input;
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
			System.out.println(auc.toString());
		}
		System.out.println("Enter the item id to increase the bid by $1.  Otherwise, enter another search: (hit enter to go back to home page)");
	}

	@Override
	public Event next() {
		String itemInput = null;
		try {
			itemInput = br.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(input == null || input.equals("")){
			
			return new UserHomeState(as, input);
		}
		
		else{
			try{
				as.bid(name, Integer.parseInt(itemInput));
			}
			catch(Exception e){
				return new SearchResultsState(as, name, itemInput);
			}
			return new SearchResultsState(as, name, input);
		}
	}
}
