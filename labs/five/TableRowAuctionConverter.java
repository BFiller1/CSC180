package labs.five;



public class TableRowAuctionConverter implements Converter<Auction> {
//id name description bid(price) owner

//	Auction a = new Auction(5, "something", "Description of something", 7);
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
//		try {
//			return tf.format(fromObject);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		String format = String.format("%-20s%-60s%-10s%-8s%-20s%-18s", fromObject.getId() + " ", fromObject.getName(), fromObject.getCurrentBid(), fromObject.getNumberOfBidsRemaining(), fromObject.getOwner(), fromObject.getEndsBy());
		return format;
	}
}
