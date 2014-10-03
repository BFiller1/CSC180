package exercises.two;

import java.util.ArrayList;

public class InMemoryAuctionService implements AuctionService{

	ArrayList<Auction> search = new ArrayList<Auction>();
	Auction a = new Auction(1, "Computer", 10);
	Auction a1 = new Auction(2, "Bag", 7);
	Auction a2 = new Auction(6, "Television", 18);

	public InMemoryAuctionService(){
		search.add(a);
		search.add(a1);
		search.add(a2);
	}

	@Override
	public Auction[] search(String criteria) {
		ArrayList<Auction> temp = new ArrayList<Auction>();
		for(Auction auc : search){
			if(auc.getName() == criteria){
				temp.add(auc);
			}
		}
		return temp.toArray(new Auction[temp.size()]);
	}

	@Override
	public void bid(String username, int itemId) {
		for(Auction auc : search){
			if(auc.getId() == itemId){
				auc.currentBid++;
				auc.owner = username;
			}

		}
	}
}
