package labs.five;

public class Driver {

	public static void main(String[] args) {
		InMemoryAuctionService imas = new InMemoryAuctionService();
		imas.FileReading(args[0]);
		EventLoop el = new EventLoop();
		el.begin();
	}
}
