package exercises.five;



public class TableRowAuctionConverter implements Converter<Auction> {
//id name description bid(price) owner
//	TableFormat tf = new TableFormat("i" + "%5s" + "n" + "%15s" + "d"  + "%50s" + "p");

	Auction a = new Auction(5, "something", "Description of something", 7);
	public TableRowAuctionConverter(){
		
	}
	
	@Override
	public Auction parse(String fromString) {
//		try {
//			return tf.parse(fromString);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return null;
	}

	@Override
	public String format(Auction fromObject) {

		return a.getId() + "%5s" + a.getName() + "%15s" + a.getDescription()  + "%50s" + a.getCurrentBid();
		
	}

}
