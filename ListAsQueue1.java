package placement.DataStructure;

public class ListAsQueue1 {

	public static void main(String[] args) throws Exception {
		LinkedListAsQueue queue=new LinkedListAsQueue();
		queue.enqueue(10);
		queue.enqueue(40);
		queue.enqueue(15);
		queue.enqueue(510);
		queue.enqueue(810);
		queue.display();
		System.out.println(queue.getFront());
		queue.dequeue();
		queue.display();
		

	}

}
