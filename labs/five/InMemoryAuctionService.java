package labs.five;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class InMemoryAuctionService implements AuctionService{
	

	TableRowAuctionConverter trac = new TableRowAuctionConverter();
	SimpleDateFormatConverter sdfc = new SimpleDateFormatConverter();
	
	Auction a = new Auction(1, "Computer", "a device used for computing", 10, 5, new Date(), "bob");
	Auction a1 = new Auction(2, "Bag", "an item used for holding other items like a queue", 7, 9, new Date(), "bob");
	Auction a2 = new Auction(3, "Television", "a device that can serve as a monitor or source of entertainment", 18, 8, new Date(), "tom");

	public InMemoryAuctionService(){
		searches.put(1l, a);
		searches.put(2l, a1);
		searches.put(3l, a2);
		
//		search.add(a);
//		search.add(a1);
//		search.add(a2);
	}
	
	public void FileReading(String filename){
		RemoteClientAuctionService client = new RemoteClientAuctionService();
		String name = "";
		String id;
		String date = null;
		String bidsRemaining;
		String current;
		long endsBy = 0;
		double currentBid = 1;
		long itemId = 0;
		int Bid;
		int bidsRem = 0;
//			byte[] b = null;
			try {
				Path p = Paths.get(filename);
				byte[] b = Files.readAllBytes(p);
				String input = new String(b);
				String[] s = input.split("<h3 class=\"lv[a-zA-Z0-9\"]+><a href=\"");
//				System.out.println(s.toString());
//				m = AUCTION_PATTERN.matcher(input);
				for(int i = 0; i < s.length; i++){
					Pattern pattern = Pattern.compile("[0-9]+</li>");
					Matcher matcher = pattern.matcher(s[i]);
					if (matcher.find()) {
					    id = (matcher.group());
					    id = id.replace("</li>", "");
					    itemId = Long.parseLong(id);
//						System.out.println("id   		" + id);
					}
					pattern = Pattern.compile("\"img\" alt=\"(?:[^\\\"]+|\\.)*\"");
					matcher = pattern.matcher(s[i]);
					if (matcher.find()) {
					    name = (matcher.group());
					    name = name.replace("\"img\" alt=\"", "");
					    name = name.replace("\"", "");
//					    System.out.println(name);
					}
//					pattern = Pattern.compile("Get it on or before <b>[a-zA-Z0-9,?.? ?]+");
					pattern = Pattern.compile("timems=\"\\d+");
					matcher = pattern.matcher(s[i]);
					if (matcher.find()) {
					    date = (matcher.group());
					    date = (date.replace("timems=\"", ""));
//					    date = (date.replace("<b>", ""));
					    endsBy = Long.parseLong(date);
					}
					pattern = Pattern.compile("<span>+[0-9]+ bid");
					matcher = pattern.matcher(s[i]);
					if (matcher.find()) {
						bidsRemaining = (matcher.group());
						bidsRemaining = bidsRemaining.replace("<span>", "");
						bidsRemaining = bidsRemaining.replace(" bid", "");
//						System.out.println("bids left		" +bidsRemaining);
//						System.out.println("Something");
						bidsRem = Integer.parseInt(bidsRemaining);
					}
//					pattern = Pattern.compile("[$]+[0-9]+.+ ");
//					pattern = Pattern.compile("$([0-9,]+\\.\\d{2}).*?(\\d+)");
					pattern = Pattern.compile("\\$\\d+,?\\d+.\\d+");
					matcher = pattern.matcher(s[i]);
					if (matcher.find()) {
					    current = (matcher.group());
					    current = current.replace("$", "");
					    current = current.replace(",", "");
//					    System.out.println("Current bid		" + currentBid);
					    currentBid = Double.parseDouble(current);
					}
					Auction a = new Auction(itemId, name, "", currentBid, bidsRem, new Date(endsBy), "System");
					searches.put(itemId, a);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	@Override
	public Auction[] search(String criteria) {

		Predicate<Auction> cp = null;
		
		ArrayList<Auction> theSearch = new ArrayList<Auction>();

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

		theSearch.addAll(CollectionUtils.filter(searches.values(), cp));
		return theSearch.toArray(new Auction[theSearch.size()]);
	}

	@Override
	public Auction bid(String username, Long itemId) throws ExpiredBidException{
//		searches.get(itemId));
		Auction a = searches.get(itemId);
			if(a != null){
				a.setCurrentBid(a.getCurrentBid()+1);
				a.setNumerOfBidsRemaining(a.getNumberOfBidsRemaining()-1);
				a.setOwner(username);
//				return a;
			}
			System.out.println("The price of " + a.getName() + " has increased to " + a.getCurrentBid() + " and the current owner is " + username + ".\n");
			return a;
	}


	@Override
	public Auction create(Auction a) {
		searches.put(a.getId(), a);
		return retrieve(a.getId());
	}

	@Override
	public Auction retrieve(Long id) {
		
		return (Auction) searches.get(id);
	}

	@Override
	public Auction update(Long id, Auction a) {
		
		searches.put(id, a);
		return retrieve(id);
	}

	@Override
	public void delete(Long id) {
		
		searches.remove(id);
	}
}