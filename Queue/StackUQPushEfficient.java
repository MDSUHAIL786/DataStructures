package placement.DataStructure.Queue;
import placement.DataStructure.QueueUsingArray;
public class StackUQPushEfficient {
	private QueueUsingArray primary;
	private QueueUsingArray secondary;
	
	public StackUQPushEfficient() throws Exception {
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
		this.primary.enQueue(data);
	}
	
	//pop
	public int pop() throws Exception {
		while(this.primary.Size()!=1) {
			this.secondary.enQueue(this.primary.deQueue());
		}
		int poped=this.primary.deQueue();
		while(this.secondary.Size()!=0) {
			this.primary.enQueue(this.secondary.deQueue());
		}
		return poped;
	}
	//peek
	public int top() throws Exception{
		while(this.primary.Size()!=1) {
			this.secondary.enQueue(this.primary.deQueue());
		}
		int poped=this.primary.deQueue();
		this.secondary.enQueue(poped);
		while(!this.secondary.isEmpty()) {
			this.primary.enQueue(this.secondary.deQueue());
		}
		return poped;
	}
	private static void reverseQ(QueueUsingArray q) throws Exception {
		if(q.isEmpty())
			return;
		int element=q.deQueue();
		reverseQ(q);
		q.enQueue(element);
		
	}
	//display
	public void Display() throws Exception{
		reverseQ(this.primary);
		this.primary.display();
		reverseQ(this.primary);
	}
	
}
