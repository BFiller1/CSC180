package exercises.five;

public class TableFormat {

	private String formatting;
	
	TableFormat(String input){
		formatting = input;
	}
	
    Auction parse(String fromString) {
    	//make a string result
    	String name = null;
    	String id = null;
    	String description = null;
    	String price = null;
    	
    	
    	//used to split strings using formatting
    	String[] format = this.formatting.split(":");
    	
    	//used to get object from the auction
    	String[] auctionObject = fromString.split(":");
    	for(int i = 0; i < this.formatting.length(); i++){
    		if(format[i].equals("i")){
    			id = auctionObject[i];
    		}
    		if(format[i].equals("n")){
    			name = auctionObject[i];

    		}
    		if(format[i].equals("d")){
    			description = auctionObject[i];

    		}
    		if(format[i].equals("p")){
    			price = auctionObject[i];

    		}
    	}
		return new Auction(Integer.parseInt(id), name, description, Integer.parseInt(price));
    }
    
    String format(Auction fromObject) {
    	String result = "";
    	for(int i = 0; i < formatting.length(); i++){
    		if(formatting.charAt(i) == 'i'){
    			result = result+fromObject.getId();
    		}
    		if(formatting.charAt(i) == 'n'){
    			result = result+fromObject.getName();

    		}
    		if(formatting.charAt(i) == 'd'){
    			result = result+fromObject.getDescription();

    		}
    		if(formatting.charAt(i) == 'p'){
    			result = result+fromObject.getCurrentBid();
    		}
    		if(formatting.charAt(i) == ',' && i < formatting.length()+1){
    			result = result+',';
    		}
    	
    	}
		return result; 
    }
}
