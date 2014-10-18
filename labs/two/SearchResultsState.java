package labs.two;

import java.io.IOException;
import java.util.Stack;


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
		//for(Auction auction : searches.values()) {
			//if(input.contains(auction.getName()) || input.contains(auction.getDescription())) {

		Stack<String> predicateStack = new Stack<String>();
		Stack<String> operatorStack = new Stack<String>();
		ContainsPredicate cp = new ContainsPredicate(input);

		if(input.contains(" AND ")){
			for(String andSplit: input.split(" AND ")){
				input = andSplit;
				operatorStack.add(" AND ");
				predicateStack.add(andSplit);
				System.out.println(predicateStack.toString());
				System.out.println(operatorStack.toString());
				//cp.evaluate(t)
			}
		}

		else if(input.contains(" OR ")){
			for(String orSplit: input.split(" OR ")){
				input = orSplit;
				operatorStack.add(" OR ");
				predicateStack.add(orSplit);
			}
		}
		//Deque<String> stringStack = new ArrayDeque<String>();
			//}
		//}
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
		String itemInput = null;
		try {
			itemInput = br.readLine();
			
		} catch (IOException e1) {
			
		}
		if(input.equals(null) || input.equals("")){
			
			return new UserHomeState(as, name);
		}
		
		else{
			try{
				as.bid(name, Integer.parseInt(itemInput));
			}
			catch(Exception e){
//				System.out.println("something is wrong");
				return new SearchResultsState(as, name, itemInput);
			}
			return new SearchResultsState(as, name, input);
		}
	}
}
