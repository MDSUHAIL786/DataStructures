package placement.DataStructure;

//queue using circular array or circular queue
public class QueueUsingArray {
	private int data[];
	private int front;
	private int size;
	public QueueUsingArray() {
		data=new int[5];
		front =0;
		size=0;
	}
	public QueueUsingArray(int capacity) throws Exception{
		if(capacity==0 || capacity<0) {
			throw new Exception("invalid capacity!!");
		}
		data=new int[capacity];
		front=0;
		size=0;
	}
	
	//insertion that is enqueue
	public void enQueue(int item) throws Exception{
		if(isFull()) {
			throw new Exception("Queue is full");
		}
		int idx=(front+size)%data.length;    //circular array 
		this.data[idx]=item;
		size++;
	}
	
	//deQueue i.e deletion
	public int deQueue() throws Exception{
		if(isEmpty()) {
			throw new Exception("cannot delete queue is empty!");
		}
		int temp =data[front];
		data[front]=0;
		front++;
		front%=data.length;
		size--;
		return temp;
	}
	
	//get front value
	public int getFront() throws Exception {
		if(isEmpty()) {
			throw new Exception("front not exist");
		}
		return data[front];
	}
	
	//size
	public int Size() {
		return size;
	}
	
	//is empty
	public boolean isEmpty() {
		return size==0;
	}
	
	//is full
	public boolean isFull() {
		return size==this.data.length;
			
	}
	
	//display
	public void display() throws Exception {
		for(int i=0;i<this.Size();i++) {
			System.out.print(this.data[(i+front)%data.length]+"  ");
		}
		System.out.println();
	}

}
