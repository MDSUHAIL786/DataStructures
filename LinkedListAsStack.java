package placement.DataStructure;

import placement.DataStructure.LinkedList.TraverseLinkedList;

public class LinkedListAsStack {
	private TraverseLinkedList stack;
	public LinkedListAsStack() {
		stack=new TraverseLinkedList();
	}
	public void push(int item) {
		stack.addFirst(item);
	}
	public int pop() throws Exception {
		return stack.removeFirst();
	}
	
	//isEmpty
	public boolean isEmpty() {
		return stack.size()==0;
	}
	
	//size
	public int size() {
		return stack.size();
	}
	
	//display
	public void display() {
		stack.display();
	}
	
	//get top
	public int getTop() throws Exception {
		return stack.getFirst();
	}

}
