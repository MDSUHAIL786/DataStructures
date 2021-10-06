package placement.DataStructure.Queue;

import placement.DataStructure.QueueUsingArray;

public class ReverseQ {

	public static void main(String[] args) throws Exception {
		QueueUsingArray q=new QueueUsingArray(10);
		for(int i=1;i<11;i++) {
			q.enQueue(i*10);
		}
		q.display();
		reverseQ(q);
		q.display();
		int t=q.deQueue();
		System.out.println(t);
		System.out.println();
		q.display();
		
		
		
	}

	public static void reverseQ(QueueUsingArray q) throws Exception {
		if(q.isEmpty())
			return;
		int element=q.deQueue();
		reverseQ(q);
		q.enQueue(element);
		
	}

}
