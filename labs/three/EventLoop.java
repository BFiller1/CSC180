package labs.three;

import java.util.LinkedList;
import java.util.Queue;




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
				toDo.add(new DefaultState(as));

				toDo.addAll(done);
				//toDo.add(new DefaultState(as));
				done.clear();
				
			}

			else{
				toDo.peek().show();
				Event event = toDo.poll();
				//done.offer(event);
				//use event to call next
				Event eventNext = event.next();

				if(eventNext.getClass() != DefaultState.class){
					//give the next event to done queue
					done.offer(eventNext);
				}
				/*
				 * 
				 * it could be the queue i may have to add a temp queue
				 */
//causes
//				try{
//					done.add(toDo.poll().next());
//				}
//				catch(Exception e){
//					
//				}
			}
			
		}
	}
	//use poll to take the top
	//and offer to add to the end
}
