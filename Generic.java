package placement.DataStructure;

public class Generic {

	public static void main(String[] args) {
		Integer a[]= {1,2,3,5,5};   //we cannot use here int
		Boolean b[]= {true,false,true,false,true,true,true}; //here boolean cannot be use
		display(a);
		display(b);
	}
	public static <AnyType> void display(AnyType ans[]) {
		for(AnyType val:ans) {
			System.out.print(val+"  ");
		}
		System.out.println();
	}

}
