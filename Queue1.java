package placement.DataStructure;

public class Queue1 {

	public static void main(String[] args) throws Exception {
		QueueUsingArray queue=new QueueUsingArray();
		System.out.println(queue.Size());
		for(int i=1;i<=5;i++) {
			queue.enQueue(i*100);
		}
//		queue.enQueue(500);
		System.out.println(queue.Size());
		queue.display();
		
		QueueUsingArray q2=new QueueUsingArray(10);
		for(int i=1;i<=5;i++) {
			q2.enQueue(i*200);
		}
		System.out.println(q2.Size());
		q2.enQueue(50);
		q2.display();
		System.out.println(q2.Size());
		queue.deQueue();
		System.out.println(queue.Size());
		queue.display();
		q2.deQueue();
		q2.deQueue();
		q2.deQueue();
		q2.enQueue(100);
		q2.enQueue(2);
		q2.deQueue();
		q2.deQueue();
		q2.deQueue();
		q2.deQueue();
		q2.display();
		System.out.println(q2.Size());
	}

}
