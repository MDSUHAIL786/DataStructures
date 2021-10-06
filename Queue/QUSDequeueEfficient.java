package placement.DataStructure.Queue;

import placement.DataStructure.DynamicStack;

public class QUSDequeueEfficient {
	private DynamicStack primary;
	private DynamicStack secondary;
	
	public QUSDequeueEfficient() throws Exception{
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
	
	//dequeue  o(1)
	public int deQ() throws Exception{
		int deleted=primary.pop();
		return deleted;
	}
	
	//enqueue  O(N)
	public void enQ(int item) throws Exception {
		while(primary.size()!=0) {
			secondary.push(primary.pop());
		}
		primary.push(item);
		while(!secondary.isEmpty()) {
			primary.push(secondary.pop());
		}
		
	}
	
	//front O(N)
	public int Front() throws Exception {
		return primary.peak();
		
	}
	
	//display O(N)
	
	public void display() throws Exception {
		this.primary.display();
	}


}
