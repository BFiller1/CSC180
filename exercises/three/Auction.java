package exercises.three;


import java.util.HashMap;
import java.util.Map;


public class Auction implements AuctionService{

	private int id;
	private int currentBid;
	private String owner;
	private String name;
	private AuctionService auctionService;
	
	//add second constructor
	//getproperty, set property, make modification toString()

	Map<String, Object> auctionMap = new HashMap<String, Object>();

	public Auction(int id, String name, int currentBid){
		this.id = id;
		this.name = name;
		this.currentBid = currentBid;
	}
	
	public Auction(Integer id, String name, Integer currentBid, Map<String, Object> properties){
		
	}
	
	public boolean equals(Auction auction){
		if(this.id == auction.id){
			return true;
		}
		else{
			return false;
		}
	}
	
	public String toString(){
		String person = "ID:" + this.id + "\n" + "Name:" + this.name + "\n" + "Current Bid:" + this.currentBid;
		return person;	
	}

	public int getId() {
		return id;
	}

//	public void setId(int id) {
//		this.id = id;
//	}

	public int getCurrentBid() {
		return currentBid;
	}

	public void setCurrentBid(int currentBid) {
		this.currentBid = currentBid;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public <T> T getProperty(String propertyname, Class<T> propertyType){
		return (T) auctionMap.get(propertyname);
	}
	
	public void setProperty(String propertyname, Object propertyValue){
		auctionMap.put(propertyname, propertyValue);
	}
	
	@Override
	public boolean equals(Object obj){
		return false;
		
	}
	
	@Override
	public int hashCode(){
		return id;
	}

	@Override
	public Auction[] search(String criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Auction bid(String username, int itemId) {
		return null;
		// TODO Auto-generated method stub
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
