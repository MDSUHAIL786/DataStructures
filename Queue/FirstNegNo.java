package placement.DataStructure.Queue;

import java.util.*;

import placement.DataStructure.LinkedListAsQueue;

public class FirstNegNo {

	public static void main(String[] args) throws Exception {
		int arr[]= {-12,-1,-7,8,-15,30,26,-28};
		Scanner o=new Scanner(System.in);
		LinkedListAsQueue q=new LinkedListAsQueue();
		int i=0,k=o.nextInt();
		o.close();
		for(;i<k;i++) {
			if(arr[i]<0)
				q.enqueue(i);
		}
		for(;i<arr.length;i++) {
			if(!q.isEmpty())
				System.out.print(arr[q.getFront()]+"  ");
			else
				System.out.print(0+"  ");
			while(!q.isEmpty() && q.getFront()<=i-k) {
				q.dequeue();
			}
			if(arr[i]<0)
				q.enqueue(i);
			
		}
		if(!q.isEmpty())
			System.out.print(arr[q.getFront()]+"  ");
		else
			System.out.print(0+"  ");
		
	}
	

}
