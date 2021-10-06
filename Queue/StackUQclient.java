package placement.DataStructure.Queue;

public class StackUQclient {

	public static void main(String[] args) throws Exception {
		StackUQPopEfficient stack=new StackUQPopEfficient();
		
		for(int i=1;i<5;i++) {
			stack.push(i*9);
		}
		stack.Display();
		System.out.println(stack.top());
		stack.Display();
		
//		System.out.println(stack.pop());
//		stack.display();
//		stack.display();

	}

}
