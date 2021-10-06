package placement.DataStructure.Queue;

import java.util.*;



public class FirstNonRepeatngChar {

	public static void main(String[] args) {
//		method1();
		method2();
		
	}

	//method 1
	public static void method1() {
		StringBuilder sb=new StringBuilder();
		Scanner o=new Scanner(System.in);
		int arr[]=new int[267];
		int n=o.nextInt();
		while(n>=0) {
			char ch=o.next().charAt(0);
			sb.append(ch);
//			char upper=;
			arr[(int)ch]++;
			arr[(int)Character.toUpperCase(ch)]++;
			for(int i=0;i<sb.length();i++) {
				if(arr[sb.charAt(i)]==1) {
					if(arr[Character.toUpperCase(sb.charAt(i))]==1) {
						System.out.println(sb.charAt(i));
						break;
					}
						
					
				}
				else if(i==sb.length()-1) {
					System.out.print(-1);
				}
			}
			n--;
		}
		
		o.close();
	}
	
	//method 2
	public static void method2() {
		HashMap<Character,Integer> map=new HashMap<>();
		
		Scanner o=new Scanner(System.in);
		char ch=o.next().charAt(0);
		Queue<Character> q=new LinkedList<>();
		while(ch!='.') {
			q.add(ch);
			if(map.containsKey(ch)) {
				int value=map.get(ch);
				map.put(ch, value+1);
				
			}else {
				map.put(ch, 1);
			}
			while(!q.isEmpty()) {
				char fc=q.peek();
				if(map.get(fc)==1) {
					System.out.println(fc);
					break;
				}else{
					q.poll();
				}
			}
			if(q.isEmpty())
				System.out.println(-1);
			ch=o.next().charAt(0);
		}
		o.close();
		
		
	}
	
	

}
