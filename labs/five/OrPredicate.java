package labs.five;

public class OrPredicate<T> implements Predicate<T> {

	Predicate<T> firstSearchString;
	Predicate<T> secondSearchString;
	
	
	OrPredicate(Predicate<T> firstSearchString, Predicate<T> secondSearchString){
		this.firstSearchString = firstSearchString;
		this.secondSearchString = secondSearchString;
	}
	
	@Override
	public boolean evaluate(T t) {
		if(firstSearchString.evaluate(t) || secondSearchString.evaluate(t)){
			return true;
		}
		else{
			return false;
		}
	}
}
