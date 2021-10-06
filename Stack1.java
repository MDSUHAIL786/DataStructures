package placement.DataStructure;

public class Stack1 {

	public static void main(String[] args) throws Exception{
		Stack obj=new Stack();
		Stack o=new Stack(10);
		o.push(45);
		o.push(78);
		o.push(85);
		o.push(4);
		o.display();
		o.pop();
		o.display();
		obj.push(1);
		obj.display();
		obj.pop();
		try {
			System.out.println(obj.peak());
			
		}
		catch(Exception e) {
			System.out.println("sorry there is no peak i.e empty stack!!!!!");
		}
		Stack obj2=new Stack(3);
		obj2.push(20);
		obj2.push(30);
		obj2.push(200);
		obj2.display();
		obj2.push(20);
		

	}

}
