package exercises.one;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionUtils {
	static int total = 0;

	public static void main(String[] args) {
		try{
		Collection c = new ArrayList();
		Cardinality("hello", null);
		System.out.println(total);
		}
		catch(Exception e){
			System.out.println("0");
		}
	}
	
	public static int Cardinality(Object obj, Collection coll){
		if(coll == null){
			throw new NullPointerException();
		}
		if(obj == null){
			throw new NullPointerException();
		}
		for(Object o : coll){
			if(o.equals(obj)){
				total++;
			}
		}
		return total;
		}
}
