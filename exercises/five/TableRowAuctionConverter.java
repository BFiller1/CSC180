package exercises.five;



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
		System.out.println("__________________________________________");
		String format = "| " + fromObject.getId() + "\t" + fromObject.getName() + "\t" + fromObject.getDescription() + "\t" + fromObject.getCurrentBid() + " |";
		return format;
	}
}
