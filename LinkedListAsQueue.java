package placement.DataStructure;

import placement.DataStructure.LinkedList.TraverseLinkedList;

public class LinkedListAsQueue {
	private TraverseLinkedList queue;
	public LinkedListAsQueue(){
		queue=new TraverseLinkedList();
	}
	// enqueue
	public void enqueue(int item){
		queue.addLast(item);
	}
	
	//dequeue
	public int dequeue() throws Exception {
		return queue.removeFirst();
	}
	
	//get front value
	public int getFront() throws Exception {
		return queue.getFirst();
	}
	
	//size 
	public int size() {
		return queue.size();
	}
	
	//isEmpty
	public boolean isEmpty() {
		return queue.size()==0;
	}
	
	//display
	public void display() {
		queue.display();
	}
	
}
	
