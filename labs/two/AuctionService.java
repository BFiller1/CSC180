package labs.two;


public interface AuctionService {

	
	Auction[] search(String criteria);
	public Auction bid(String username, int itemId);
		
	public Auction create(Auction a);
	public Auction retrieve(Integer id);
	public Auction update(Integer id, Auction a);
	public void delete(Integer id);
}
