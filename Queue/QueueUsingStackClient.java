package placement.DataStructure.Queue;

public class QueueUsingStackClient {

	public static void main(String[] args) throws Exception {
		QueueUsingStackEnqueueEfficient q=new QueueUsingStackEnqueueEfficient();
		QUSDequeueEfficient q2=new QUSDequeueEfficient();
		
		for(int i=1;i<=10;i++) {
			q.enQ(i*10);
			q2.enQ(i*2);
		}
		q.display();
		q2.display();
		System.out.println(q.deQ());
		System.out.println(q2.deQ());
		q.display();
		q2.display();
		System.out.println(q.Front());
		System.out.println(q2.Front());
		q2.display();
		
		System.out.println(q2.size());
	}

}
