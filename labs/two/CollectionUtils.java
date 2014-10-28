package labs.two;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionUtils {
	static int total = 0;

	public static int Cardinality(Object obj, Collection<Auction> coll){

		for(Object o : coll){
			if(o.equals(obj)){
				total++;
			}
		}
		return total;
		}
	//takes in collection of type T and predicate of type T
	public static <T> Collection<T> filter(Collection<T> collection, Predicate<T> predicate){
		Collection<T> temp = new ArrayList<T>();
		for(T t : collection){
			if(predicate.evaluate(t)){
				temp.add(t);
			}
		}
		return temp;
	}
}
