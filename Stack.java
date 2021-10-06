package placement.DataStructure;

public class Stack {
//	private int data[];
//	private int top;
	protected int data[]; //specifier change so that this data member can be access by child class in same package
	protected int top;
	//constructor
	public Stack() {
		data=new int[5];
		top=-1;
	}
	
	//parameterized constructor
	public Stack(int Capacity) throws Exception {
		if(Capacity==1) {
			throw new Exception("invalid capacity!");
		}
		data=new int[Capacity];
		top=-1;
	}
	
	//push or insert an element
	
	public void push(int item) throws Exception {
		if(isFull()) {
			throw new Exception("Stack is full.");
		}
		top++;
		data[top]=item;
	}
	//pop a element
	public int pop() throws Exception{
		if(isEmpty()) {
			throw new Exception("Stack is Empty.");
		}
		int temp=data[top];
		data[top]=0;  //not mandatory
		top--;
		
		return temp;
	}
	
	//return top element
	public int peak() throws Exception {
		if(isEmpty()) {
			throw new Exception("Stack is Empty.");
		}
		int temp=data[top];
		return temp;
	}
	
	//size
	public int size() {
		return top+1;
	}
	
	//isEmpty
	public boolean isEmpty(){
//		if(top==-1) 
//			return true;
//		return false;
		
//		or
		
		return size()==0;
	}
	
	//isfull
	public boolean isFull() {
		return size()==data.length;
	}
	//display
	public void display() {
		for(int i=top;i>=0;i--) {
			System.out.print(data[i]+"  ");
		}
		System.out.println("END");
		
	}
}
