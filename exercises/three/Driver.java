package exercises.three;

public class Driver {

	public static void main(String[] args) {
//		EventLoop el = new EventLoop();
//		el.begin();
		InMemoryAuctionService imas = new InMemoryAuctionService();
		System.out.println(imas.searches);
		Auction a = new Auction(4, "something", 2);
		Auction a1 = new Auction(5, "something else", 9);
		a.setProperty("This is a new property", 5);
		a.getProperty("", null);
		System.out.println("Auction object created.");
		System.out.println(imas.create(a));
		System.out.println("Another Auction object created.");
		System.out.println(imas.create(a1));
		System.out.println("First Auction object retrieved.");
		System.out.println(imas.retrieve(a.getId()));
		System.out.println("Auction object updated");
		System.out.println(imas.update(imas.a.getId(), a));
		System.out.println("Auction object deleted.");
		System.out.println(imas.searches);
	}
}
