package exercises.four;


public class Tester {

	public static void main(String[] args) {
		InMemoryAuctionService imas = new InMemoryAuctionService();
		Auction a = new Auction(12, "pizza", 5);
		Auction a1 = new Auction(33, "something", 8);
		System.out.println(a.toString());
		System.out.println("The auction object was printed out.");
		System.out.println(a.equals(a));
		System.out.println(a.equals(a1));
		
		System.out.println("Search results for 'Computer'");
		Auction[] results = imas.search("Computer");
		for(int i = 0; i < results.length; i++){
			System.out.println(results[i].toString());
		}
		
		System.out.println("Search results for 'something'");
		Auction[] falseResults = imas.search("something");
		for(int i = 0; i < falseResults.length; i++){
			System.out.println(falseResults[i].toString());
		}
	}
}
