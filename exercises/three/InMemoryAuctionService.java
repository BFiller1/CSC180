package exercises.three;

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
		ArrayList<Auction> temp = new ArrayList<Auction>(searches.values());
		for(Auction auc : temp){
			if(auc.getName().equalsIgnoreCase(criteria)){
				temp.add(auc);
			}
		}
		return temp.toArray(new Auction[temp.size()]);
	}

	@Override
	public Auction bid(String username, int itemId) {
		searches.get(searches.get(itemId));
		for(Auction auc : searches.values()){
			if(searches.get(itemId) != null){
				auc.setCurrentBid(auc.getCurrentBid()+1);
//				auc.currentBid++;
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
