package Lab;

import java.util.LinkedList;
import java.util.Queue;
import exercises.two.*;



public class EventLoop {

	AuctionService as = new InMemoryAuctionService();
	
	
		Queue<Event> toDo = new LinkedList<Event>();

		Queue<Event> done = new LinkedList<Event>();

		//todo.poll();
		//done.offer();
	
	public EventLoop(){
		toDo.add(new DefaultState(as));
		toDo.add(new DefaultState(as));

	}
	
	
	void begin() {
		while(true){
			if(toDo.isEmpty() == true){
				toDo.addAll(done);
				toDo.add(new DefaultState(as));
				done.clear();
			}
			if(toDo.peek() == null){
				toDo.remove();
			}
			else{
				toDo.peek().show();
				done.add(toDo.poll().next());
			}

			
		}
	}
	//use poll to take the top
	//and offer to add to the end

}
