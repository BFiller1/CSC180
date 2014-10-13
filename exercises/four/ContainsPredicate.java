package exercises.four;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import exercises.three.*;
public class ContainsPredicate implements Predicate<Auction> {

	private String criteria;
	Map<Integer, Auction> searches = new HashMap<Integer, Auction>();

	public ContainsPredicate(String criteria){
		this.criteria = criteria;
	}
//has generic type auction
	Auction[] search(String criteria){
		ArrayList<Auction> temp = new ArrayList<Auction>(searches.values());
		for(Auction auc : temp){
			if(auc.getName().equalsIgnoreCase(criteria)){
				temp.add(auc);
			}
		}
		return temp.toArray(new Auction[temp.size()]);
	}



	@Override
	public boolean evaluate(Auction t) {
		
		//it will return something like this
		return t.getName().contains(criteria);
	}

}
