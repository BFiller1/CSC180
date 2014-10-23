package exercises.five;

import java.util.HashMap;
import java.util.Map;

import exercises.four.AuctionService;


public class Auction{

	private int id;
	private int currentBid;
	private String owner;
	private String name;
	private String description;
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private AuctionService auctionService;
	
	//add second constructor
	//getproperty, set property, make modification toString()

	Map<String, Object> auctionMap = new HashMap<String, Object>();

	public Auction(int id, String name, String description, int currentBid){
		this.id = id;
		this.name = name;
		this.currentBid = currentBid;
		this.description = description;
		//this.owner = owner;
	}
	
//	public Auction(Integer id, String name, Integer currentBid, Map<String, Object> properties){
//		
//	}
	
	public boolean equals(Auction auction){
		if(this.id == auction.id){
			return true;
		}
		else{
			return false;
		}
	}
	
	public String toString(){
		String person = "ID: " + this.id + "\n" + "Name: " + this.name + "\n" + "Current Bid: " + this.currentBid + "\n" + "Owner: " + this.owner;
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
	
	public Object getProperty(String propertyname){
		return auctionMap.get(propertyname);
	}
	
	public <T> T getProperty(String propertyname, Class<T> propertyType){
		return propertyType.cast(auctionMap.get(propertyname));
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
}

