package placement.DataStructure.Queue;

import placement.DataStructure.DynamicStack;


public class QueueUsingStackEnqueueEfficient{
	private DynamicStack primary;
	private DynamicStack secondary;
	
	public QueueUsingStackEnqueueEfficient() throws Exception{
		this.primary=new DynamicStack();
		this.secondary=new DynamicStack();
	}
	
	//empty
	public boolean isEmpty() {
		return primary.size()==0;
	}
	//size
	public int size() {
		return primary.size();
	}
	
	//enqueue  o(1)
	public void enQ(int item) throws Exception{
		primary.push(item);
	}
	
	//dequeue  O(N)
	public int deQ() throws Exception {
		while(primary.size()!=1) {
			secondary.push(primary.pop());
		}
		int delete= primary.pop();
		while(!secondary.isEmpty()) {
			primary.push(secondary.pop());
		}
		return delete;
	}
	
	//front O(N)
	public int Front() throws Exception {
		while(primary.size()!=1) {
			int element=primary.pop();
			secondary.push(element);
		}
		int front=primary.peak();
		while(!secondary.isEmpty()) {
			int element=secondary.pop();
			primary.push(element);
		}
		return front;
		
	}
	
	//display O(N)
	
	public void display() throws Exception {
		primary.ReverseStack(primary,secondary, 0);
		primary.display();
		primary.ReverseStack(primary, secondary, 0);
	}

}
