package labs.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class ContainsPredicate implements Predicate<Auction> {

	private String criteria;
	Map<Integer, Auction> searches = new HashMap<Integer, Auction>();

	public ContainsPredicate(String criteria){
		this.criteria = criteria;
	}

	@Override
	public boolean evaluate(Auction t) {
		ArrayList<Auction> temp = new ArrayList<Auction>(searches.values());
		for(Auction auc : temp){
			if(auc.getName().equalsIgnoreCase(criteria)){
				temp.add(auc);
			}
		}
		return t.getName().contains(criteria) || t.getDescription().contains(criteria);
	}
}
