package exercises.two;

public interface AuctionService {

	Auction[] search(String criteria);
	public void bid(String username, int itemId);
	
}
