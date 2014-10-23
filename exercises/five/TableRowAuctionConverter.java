package exercises.five;



public class TableRowAuctionConverter implements Converter<Auction> {
//id name description bid(price) owner
	TableFormat tf = new TableFormat("i: n: d: p");

	public TableRowAuctionConverter(){
		
	}
	
	@Override
	public Auction parse(String fromString) {
		try {
			return tf.parse(fromString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String format(Auction fromObject) {
		try{
			return tf.format(fromObject);
		}
		catch(Exception e){
			
		}
		return null;
		
	}

}
