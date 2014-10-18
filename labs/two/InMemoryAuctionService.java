package labs.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class InMemoryAuctionService implements AuctionService{
	
	Map<Integer, Auction> searches = new HashMap<Integer, Auction>();

	//ArrayList<Auction> search = new ArrayList<Auction>();
	Auction a = new Auction(1, "Computer", "A device used for computing", 10);
	Auction a1 = new Auction(2, "Bag", "An item used for holding other items like a queue", 7);
	Auction a2 = new Auction(3, "Television", "A device that can serve as a monitor or source of entertainment", 18);

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

		ContainsPredicate cp = new ContainsPredicate(criteria);

		ArrayList<Auction> theSearch = new ArrayList<Auction>();
		theSearch.addAll(CollectionUtils.filter(searches.values(), cp));
		
//		for(Auction auction : searches.values()) {
//			if(criteria.contains(auction.getName()) || criteria.contains(auction.getDescription())) {
//			}
//		}
		
//		if(auc.getName().equalsIgnoreCase(criteria)){
//			temp.add(auc);
//		}
//	}
//	return temp.toArray(new Auction[temp.size()]);
		return theSearch.toArray(new Auction[theSearch.size()]);
	}

	@Override
	public Auction bid(String username, int itemId) {
		searches.get(searches.get(itemId));
		for(Auction auc : searches.values()){
			if(searches.get(itemId) != null){
				auc.setCurrentBid(auc.getCurrentBid()+1);
				auc.setOwner(username);
				return auc;
			}
		}
		return null;
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