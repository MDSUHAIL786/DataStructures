package placement.DataStructure;

public class NextGreater {

	public static void main(String[] args) throws Exception{
		int arr[]= {2,1,3,8,6,7,5};
//		NextLargest(arr,arr.length);
		rev(arr,arr.length);
	}
	public static void NextLargest(int a[],int n) throws Exception {
		for(int i=0;i<n;i++) {    
			int max=-1;
			int item=a[i];
			Stack tempStack=new Stack(n);
			for(int j=n-1;j>i;j--) tempStack.push(a[j]);
			for(int k=i+1;k<n;k++) {
				int t=tempStack.pop();
				if(t>item) {
					max=t;
					break;
				}
				
			}
			System.out.println(a[i]+"------->"+max); 
				
			
		}
	}
	//2nd method in o(n) time complexity
	
	public static void rev(int arr[],int n) throws Exception  {

		Stack o=new Stack();
		
		for(int i=0;i<n;i++) {
			
			while(!o.isEmpty() && arr[i]>o.peak()) {
				int item=o.pop();
				System.out.println(item+"------->"+arr[i]);
			}
			o.push(arr[i]);
		}
		while(!o.isEmpty()) {
			int item=o.pop();
			System.out.println(item+"------->"+-1);
		}
		
	}

}
