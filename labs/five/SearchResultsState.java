package labs.five;

import java.io.IOException;
import java.util.ArrayList;


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
		if(auctionResults.length > 0){
			System.out.println(String.format("%-20s%-100s%-15s%-15s%-20s%-18s", "ID:", "Name:", "Current Bid:", "Bid Count:", "Owner:", "Ends By:"));
		}
		ArrayList<Long> auctionIds = new ArrayList<Long>();
		for(Auction auc : auctionResults){
				System.out.println(auc.toString());
				if(auc.getCreator().equals(name)){
					FileBasedDatasource fbd = new FileBasedDatasource();
					fbd.editing(auc);
				}
				auctionIds.add(auc.getId());
		}
		if(auctionResults.length == 0){
			System.out.println(name + ", no results match the search criteria of '" + input + "'.");
			System.out.println("Enter another search or hit 'enter' to go back to home page.");
		}
		else{
			System.out.println("\n" + "Enter the item id to increase the bid by $1.  Otherwise, enter another search: (hit enter to go back to home page)");
//			boolean loop = false;
//			do{
//			for(Long id : auctionIds){
//				if(input.equals(id.toString())){
//					loop = true;
//				}
//				else{
//					System.out.println("try again");
//					loop = false;
//				}
//			}
//			}
//			while(loop = false);
		}
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
				as.bid(name, Long.parseLong(input));
			}
			catch(Exception e){
				return new SearchResultsState(as, name, input);
			}
			return new UserHomeState(as, name);
		}
	}
}
