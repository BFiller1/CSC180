package labs.three;

public class ExpiredBidException extends Exception{

	Auction a;
	//if auction items end date is expired and expired items will be excluded
	public void exception(){
		long result = a.getTimeLeftInMillis();
		if(result <= 0){
			System.out.println("The bid for " + a.getName() + " has expired.");
		}
	}
}
