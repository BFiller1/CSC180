package exercises.three;

import java.util.LinkedList;
import java.util.Queue;

import Lab.DefaultState;
import Lab.Event;
import exercises.two.AuctionService;
import exercises.two.InMemoryAuctionService;

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


void begin()  {
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
			try{
				done.add(toDo.poll().next());
			}
			catch(Exception e){
				
			}
		}
		
	}
}
}
