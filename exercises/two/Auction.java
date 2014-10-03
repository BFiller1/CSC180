package exercises.two;

public class Auction {

	private int id;
	public int currentBid;
	public String owner;
	public String name;
	public AuctionService auctionService;
	
	

	public Auction(int id, String name, int currentBid){
		this.id = id;
		this.name = name;
		this.currentBid = currentBid;
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

	public void setId(int id) {
		this.id = id;
	}

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

}
