package placement.DataStructure.LinkedList;

public class TraverseLinkedList {
	private class Node{
		int data;
		Node Next;
	}
	private Node head,tail;
	private int size;
	
	//add last i.e insertion
	public void addLast(int item) {
		Node n=new Node();
		n.data=item;
		n.Next=null;
		if(size==0) {
			head=n;
			tail=n;
			size++;
		}else {
			tail.Next=n;
			tail=n;
			size++;
		}
	}
	
	//add first
	public void addFirst(int item) {
		//new node
		Node n=new Node();
		n.data=item;
		n.Next=null;
		
		
		
		//update summary object i.e head,tail and size
		if(size==0) {
			head=n;
			tail=n;
			size++;
		}else {
			n.Next=head;
			head=n;
			size++;
		}
	}
	
	//add at position
	public void addAt(int idx,int item) throws Exception{
		if(idx==size)
			addLast(item);
		else if(idx==0)
			addFirst(item);
		else {
			
			Node newNode=new Node();
			newNode.data=item;
			newNode.Next=null;
			
			Node previous=getNodeAt(idx-1);
			Node AddAtNode=getNodeAt(idx);   //or =previous.Next;
			
			previous.Next=newNode;
			newNode.Next=AddAtNode;
			this.size++;
		}
	}
	
	//get first node data
	public int getFirst() throws Exception {
		if(size==0)
			throw new Exception("Linked List is Empty!!!");
		return this.head.data;
		
		
	}
	
	//get last node's data
	public int getLast() throws Exception {
		if(size==0)
			throw new Exception("Linked List is Empty!!!");
		return this.tail.data;
	}
	
	//get node's data at position
	public int getAt(int position) throws Exception {
//		if(size==0)
//			throw new Exception("Linked List is Empty!!!");
//		if(position<0 || position>=size)
//			throw new Exception("invalid position");
//		Node temp=head;
//		for(int i=1;i<=position;i++) {
//			temp=temp.Next;
//		}
//		return temp.data;
//		
//		or
		return getNodeAt(position).data;
		
	}
	
	//get node at
	private Node getNodeAt(int position) throws Exception {
		if(size==0)
			throw new Exception("Linked List is Empty!!!");
		if(position<0 || position>=size)
			throw new Exception("invalid position");
		Node temp=head;
		for(int i=1;i<=position;i++) {
			temp=temp.Next;
		}
		return temp;
		
	}
	
	//remove first node
	public int removeFirst() throws Exception{
		if(size==0)
			throw new Exception("Empty!!!");
		int deleteData=head.data;
		if(size==1) {
			this.head=null;
			this.tail=null;
			size=0;
			
		}else {
			head=head.Next;
			size--;
			
		}
		return deleteData;
		
	}
	
	//remove last
	public int removeLast() throws Exception{
		if(this.size==0)
			throw new Exception("Empty!!!");
		int deleteData=tail.data;
		if(this.size==1) {
			this.head=null;
			this.tail=null;
			this.size=0;
			
		}else {
			Node temp=getNodeAt(size-2);
			this.tail=temp;
			this.tail.Next=null;
			this.size--;
			
		}
		return deleteData;
	}
	
	//remove at 
	public int removeAt(int idx) throws Exception {
		if(size==0)
			throw new Exception("Empty!!");
		if(idx<0 || idx>=size)
			throw new Exception("invalid position");
		int ans=getNodeAt(idx).data;
		if(idx==0) removeFirst();
		else if(idx==size-1) removeLast();
		else {
			Node NodeToDel=getNodeAt(idx);
			Node prev=getNodeAt(idx-1);
			prev.Next=NodeToDel.Next;
			NodeToDel.Next=null;
			size--;
		}
		
		return ans;
	}
	
	//reverse Linked list from data
	public void reverseData() throws Exception {
		if(size==0)
			throw new Exception("Empty!");
		if(size==1) return;
		int low=0,high=size-1;
		while(low<=high) {
			Node first=getNodeAt(low);
			Node last=getNodeAt(high);
			int temp=first.data;
			first.data=last.data;
			last.data=temp;
			low++;
			high--;
		}
	}
	
	//reverse pointer
	public void reversePointer() throws Exception {
		if(size==0)
			throw new Exception("Empty!");
		Node prev=head;
		Node curr=prev.Next;
		
		while(curr != null) {
			Node ahead=curr.Next;
			curr.Next=prev;
			prev=curr;
			curr=ahead;
		}
		
		Node t=head;
		head=tail;
		tail=t;
		tail.Next=null;
		
	}
	
	//mid node using size of linked list
	public int midNode() throws Exception {
		int low=0,high=size-1;
		while(low<=high) {
			if(low==high) {
				Node ans=getNodeAt(low);
				return ans.data;
			}
			low++;high--;
		}
		Node ans=getNodeAt(low-1);
		return ans.data;
		
	}
	//mid node without using size
	public int midNode2() {
		Node slow=head;
		Node fast=head;
		while(fast.Next!=null && fast.Next.Next != null) {
			
			slow=slow.Next;
			fast=fast.Next.Next;
		}
		return slow.data;
	}
	//size of Linked list
	public int size() {
		return size;
	} 
	
	
	//kth Node from last 
	public int LastKthNode(int k) throws Exception {
		if(k<=0 || k>this.size)
			throw new Exception("invalid value of k please enter valid value");
		Node slow=new Node();
		Node fast=new Node();
		
		slow=head;
		fast=getNodeAt(k-1);
		while(fast.Next != null) {
			fast=fast.Next;
			slow=slow.Next;
		}
		return slow.data;
	}
	//display linked list
	public void display() {
		System.out.println("-------------------------");
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data+", ");
			temp=temp.Next;
		}
		System.out.println(".");
		System.out.println("-------------------------");
	}
	

}
