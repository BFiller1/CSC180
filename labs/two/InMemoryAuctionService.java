package labs.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class InMemoryAuctionService implements AuctionService{
	


	//ArrayList<Auction> search = new ArrayList<Auction>();
	Auction a = new Auction(1, "Computer", "a device used for computing", 10);
	Auction a1 = new Auction(2, "Bag", "an item used for holding other items like a queue", 7);
	Auction a2 = new Auction(3, "Television", "a device that can serve as a monitor or source of entertainment", 18);

	public InMemoryAuctionService(){
		searches.put(1, a);
		searches.put(2, a1);
		searches.put(3, a2);
//		search.add(a);
//		search.add(a1);
//		search.add(a2);
	}

	@Override
	public Auction[] search(String criteria) {

		Predicate<Auction> cp = null;
		
		ArrayList<Auction> theSearch = new ArrayList<Auction>();
		//for(Auction auction : searches.values()) {
			//if(criteria.contains(auction.getName()) || criteria.contains(auction.getDescription())) {

		Stack<Predicate<Auction>> predicateStack = new Stack<Predicate<Auction>>();
		Stack<String> operatorStack = new Stack<String>();

		Predicate<Auction> firstSearchString;
		Predicate<Auction> secondSearchString;

		/*if(stringSplit.equals("NOT")){
		 *		this method should check if a name or description does not contain
		 * 		the search criteria and not will have to be checked first 
		 * 		then and then or
		 */
			for(String stringSplit: criteria.split(" ")){
				//criteria = stringSplit;
				if(stringSplit.equalsIgnoreCase("AND")){
					
					operatorStack.add(stringSplit.trim());
				}
				else if(stringSplit.equalsIgnoreCase("OR")){
					
//					Pop off the top two from the predicate stack and the top one from the
//					operator stack. Take the two predicates and use them to create an
//					AndPredicate. Place it onto the predicate stack.
//					Now that AND is off, place OR on the operator stack.
					
						operatorStack.add(stringSplit.trim());
					while(operatorStack.peek().equalsIgnoreCase("AND") && !operatorStack.isEmpty()){
						operatorStack.pop();
						firstSearchString = predicateStack.pop();
						secondSearchString = predicateStack.pop();
						 cp = new AndPredicate<Auction>(firstSearchString, secondSearchString);
						predicateStack.add(cp);
					}
				}
				else{
					predicateStack.add(cp = new ContainsPredicate(stringSplit.trim()));
//					operatorStack.push(stringSplit);
				}
				
				//operatorStack.add(" AND ");
				//predicateStack.add(andSplit);
				//loop through index
			}
			while(!operatorStack.isEmpty()){
				
//				Step Five. Pop off the top two from the predicate stack and the top
//				one from the operator stack. Take the two predicates and use them to
//				create an AndPredicate. Place it onto the predicate stack.
				
				firstSearchString = predicateStack.pop();
				secondSearchString = predicateStack.pop();
				if(operatorStack.pop().equalsIgnoreCase("AND")){
					 cp = new AndPredicate<Auction>(firstSearchString, secondSearchString);
					 predicateStack.add(cp);
				}
				else{
					cp = new OrPredicate<Auction>(firstSearchString, secondSearchString);
					predicateStack.add(cp);

				}
				//operatorStack.add(stringSplit.trim());
//				op = new OrPredicate<Auction>(firstSearchString, secondSearchString);

				if(operatorStack.isEmpty()){
					predicateStack.pop();
				}
			}
			//Checker the stacks
//			System.out.println(predicateStack.toString());
//			System.out.println(operatorStack.toString());

		theSearch.addAll(CollectionUtils.filter(searches.values(), cp));
		return theSearch.toArray(new Auction[theSearch.size()]);
	}

	@Override
	public Auction bid(String username, int itemId) {
//		searches.get(itemId));
		Auction a = searches.get(itemId);
			if(a != null){
				a.setCurrentBid(a.getCurrentBid()+1);
				a.setOwner(username);
//				return a;
			}
			return a;
	}


	@Override
	public Auction create(Auction a) {
		searches.put(a.getId(), a);
		return retrieve(a.getId());
	}

	@Override
	public Auction retrieve(Integer id) {
		
		return (Auction) searches.get(id);
	}

	@Override
	public Auction update(Integer id, Auction a) {
		
		searches.put(id, a);
		return retrieve(id);
	}

	@Override
	public void delete(Integer id) {
		
		searches.remove(id);
	}
}