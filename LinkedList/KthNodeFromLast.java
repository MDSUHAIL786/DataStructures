package placement.DataStructure.LinkedList;

import java.util.Scanner;

public class KthNodeFromLast{
	public static void main(String args[]) throws Exception {
		TraverseLinkedList list=new TraverseLinkedList();
		Scanner o=new Scanner(System.in);
		list.addLast(50);
		list.addLast(80);
		list.addLast(70);
		list.addLast(40);
		list.addLast(520);
		list.addLast(505);
		list.addLast(56);
		list.addLast(51);
		list.addLast(57);
		
		
		list.display();
		System.out.println(list.LastKthNode(o.nextInt()));
		
		o.close();
		
		
		
	}
	
}
