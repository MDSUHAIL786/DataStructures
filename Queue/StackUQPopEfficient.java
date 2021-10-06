package placement.DataStructure.Queue;

import placement.DataStructure.QueueUsingArray;

public class StackUQPopEfficient {
	private QueueUsingArray primary;
	private QueueUsingArray secondary;
	
	public StackUQPopEfficient() throws Exception {
		this.primary=new QueueUsingArray();
		this.secondary=new QueueUsingArray();
	}
	
	//size
	public int size() {
		return primary.Size();
	}
	
	//isEmpty
	public boolean isEmpty() {
		return primary.isEmpty();
	}
	//push
	public void push(int data) throws Exception{
		while(this.primary.Size()!=0) {
			this.secondary.enQueue(this.primary.deQueue());
		}
		primary.enQueue(data);
		while(this.secondary.Size()!=0) {
			this.primary.enQueue(this.secondary.deQueue());
		}
	
	}
	
	//pop
	public int pop() throws Exception {
		return this.primary.deQueue();
	}
	//peek
	public int top() throws Exception{
		return this.primary.getFront();
	}

	//display
	public void Display() throws Exception{
		this.primary.display();
	}

}
