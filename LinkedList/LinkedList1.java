package placement.DataStructure.LinkedList;

public class LinkedList1 {

	public static void main(String[] args) throws Exception {
		TraverseLinkedList LL=new TraverseLinkedList();
		LL.addLast(10);
		LL.addLast(70);
		LL.addLast(70);
		LL.addLast(80);
		LL.addLast(100);
		LL.addLast(105);
//		LL.display();
		LL.addFirst(52);
		LL.addFirst(845);
		LL.addFirst(84);
//		LL.display();
//		try {
//			
//			System.out.println("first element is : "+LL.getFirst());
//		}
//		catch (Exception e){
//			System.out.println("error");
//		}
//		System.out.println(LL.getLast());
//		System.out.println(LL.size());
//		System.out.println(LL.getAt(2));
//		LL.addAt(0, 100021);
//		LL.addAt(9, 1);
//		LL.addAt(4, 3);
//		LL.display();
//		LL.removeFirst();
//		LL.display();
//		System.out.println(LL.size());
//		LL.removeFirst();System.out.println(LL.removeLast());
//		LL.removeAt(6);
//		LL.display();
		LL.addLast(20);
		LL.addLast(200);
		LL.addLast(120);
		LL.addLast(520);
		LL.display();
		LL.addFirst(8);
		LL.addAt(4, -85);
		LL.removeLast();
		LL.display();
//		LL.reverseData();
//		LL.removeFirst();
//		LL.display();
//		System.out.println("last element is"+LL.getLast());
		System.out.println(LL.size());
//		LL.reversePointer();
//		LL.display();
//		System.out.println(LL.size());
		


	}

}
