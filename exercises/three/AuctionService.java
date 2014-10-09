package exercises.three;



public interface AuctionService {


	
	Auction[] search(String criteria);
	public Auction bid(String username, int itemId);
	
	//create, retrieve, update, delete
	
	public Auction create(Auction a);
	public Auction retrieve(Integer id);
	//should throw IdMismatchException
	public Auction update(Integer id, Auction a);
	public void delete(Integer id);
	
//	public Auction create(Auction a){
//		search.put(a.getId(), a);
//		return retrieve(a);
//	}
//	public Auction retrieve(Integer id){
//		return search.get(a);
//	}
//	//should throw IdMismatchException
//	public Auction update(Integer id, Auction a){
//		
//		search.put(id, a);
//		return retrieve(id);
//	}
//	public void delete(Integer id){
//	search.remove(id);
//	}
	
}
