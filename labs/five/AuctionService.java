package labs.five;

import java.util.HashMap;
import java.util.Map;


public interface AuctionService {

	Map<Long, Auction> searches = new HashMap<Long, Auction>();

	
	Auction[] search(String criteria);
	public Auction bid(String username, Long id) throws ExpiredBidException;
		
	public Auction create(Auction a);
	public Auction retrieve(Long id);
	public Auction update(Long id, Auction a);
	public void delete(Long id);
}
