package placement.DataStructure;

public class DynamicClient1 {

	public static void main(String[] args) throws Exception {
		Stack obj=new DynamicStack(5);
		System.out.println(obj.size());
		for(int i=1;i<=5;i++) {
			obj.push(i*10);
		}
		obj.display();
		System.out.println(obj.size());
		obj.push(40);
		obj.push(90);
		obj.push(110);
		obj.push(11);
		obj.push(12);
		obj.push(18);
		obj.display();
		System.out.println(obj.size());
		int i=4;
		while(i>0) {
			obj.pop();   
			i--;
		}
		obj.display();

	}

}
