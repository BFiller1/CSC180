package exercises.four;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;




public class InMemoryAuctionService implements AuctionService{
	
	Map<Integer, Auction> searches = new HashMap<Integer, Auction>();

	//ArrayList<Auction> search = new ArrayList<Auction>();
	Auction a = new Auction(1, "Computer", 10);
	Auction a1 = new Auction(2, "Bag", 7);
	Auction a2 = new Auction(3, "Television", 18);

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

		CollectionUtils cu = new CollectionUtils();
		Predicate<Auction> cp = new ContainsPredicate(criteria);

//		if(auc.getName().equalsIgnoreCase(criteria)){
//			temp.add(auc);
//		}
//	}
//	return temp.toArray(new Auction[temp.size()]);
		return cu.<Auction>filter(searches.values(), cp).toArray(new Auction[cu.<Auction>filter(searches.values(), cp).size()]);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Auction retrieve(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Auction update(Integer id, Auction a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}
}