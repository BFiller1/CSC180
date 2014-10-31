package labs.three;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;



public class Auction{

	private int id;
	private int currentBid;
	int numberOfBidsRemaining = 1;
	private String description;
	private String owner;
	private String name;
	private long timeLeftInMillis;
	private Date endsBy;
	
	//(?:Item: )([0-9]+) for ids just get second group
	//add second constructor
	//getproperty, set property, make modification toString()
//	Calendar c = Calendar.getInstance();
//	c.add(Calendar.DAY_OF_YEAR, 7);
//	Date timeLeftInMillis = c.getTime();

	Map<String, Object> auctionMap = new HashMap<String, Object>();

	SimpleDateFormatConverter sdfc = new SimpleDateFormatConverter();
	TableRowAuctionConverter trac = new TableRowAuctionConverter();

	public Auction(int id, String name, String description, int currentBid, int numberOfBidsRemaining, Date endsBy){
		this.id = id;
		this.name = name;
		this.description = description;
		this.currentBid = currentBid;
		this.numberOfBidsRemaining = numberOfBidsRemaining;
		this.endsBy = endsBy;
		//this.owner = owner;
	}
	
//	public Auction(Integer id, String name, Integer currentBid, Map<String, Object> properties){
//		
//	}
	public long getTimeLeftInMillis(){
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(this.timeLeftInMillis);
		return c.getTimeInMillis();
	}
	
	public Date getEndsBy(){
		return endsBy;
	}
	
	public void setEndsBy(Date endsBy) {
		this.endsBy = endsBy;
	}

	public int getNumberOfBidsRemaining() {
		return numberOfBidsRemaining;
	}

	public void setNumerOfBidsRemaining(int numberOfBidsRemaining) {
		this.numberOfBidsRemaining = numberOfBidsRemaining;
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
//		String person = "ID: " + this.id + "\n" + "Name: " + this.name + "\n" + "Description: " + this.description + "\n" + "Current Bid: " + this.currentBid + "\n" + "Owner: " + this.owner + "\n" + "Bids Remaining: " + this.bidsRemaining;
		return trac.format(this);	
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
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
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
