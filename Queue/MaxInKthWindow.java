package placement.DataStructure.Queue;

import java.util.*;
public class MaxInKthWindow {

	public static void main(String[] args) {
		Scanner i=new Scanner(System.in);
		int arr[]=new int[] {12,45,7,8,74,2,2,0,1};
		int k=i.nextInt();
		MaxItem(arr,k);
		i.close();
	}

	public static void MaxItem(int[] arr, int k) {
		Deque<Integer> q=new LinkedList<>();
		int n=arr.length,i;
		for(i=0;i<k;i++) {
			while(!q.isEmpty() && arr[i]>arr[q.getLast()] ) {
				q.removeLast();
			}
			q.addLast(i);
		}
		System.out.println(i);
		for(;i<n;i++) {
			System.out.print(arr[q.getFirst()]+"  ");
			while(!q.isEmpty() && q.getFirst()<=i-k) {
				q.removeFirst();
			}
			while(!q.isEmpty() && arr[i]>arr[q.getLast()] ) {
				q.removeLast();
			}
			q.addLast(i);
		}
		System.out.print(arr[q.getFirst()]);
	}

}
