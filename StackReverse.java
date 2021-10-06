package placement.DataStructure;

import java.util.Scanner;

public class StackReverse {

	public static void main(String[] args) throws Exception {
		Stack stack = new DynamicStack();
		Stack helper = new DynamicStack();
		Scanner i = new Scanner(System.in);
		int n = i.nextInt(), j = 0;
		while (j < n) {
			stack.push(i.nextInt());
			j++;
		}
		System.out.print("Stack before reverse : ");
		stack.display();
		ReverseStack(stack, helper, 0);
		System.out.print("Stack after reverse : ");
		stack.display();
		i.close();

	}

	private static void ReverseStack(Stack stack, Stack helper, int index) throws Exception {
		if (stack.isEmpty()) {
			return;
		}
		int item = stack.pop();
		ReverseStack(stack, helper, index + 1);
		helper.push(item);
		if (index == 0) {
			while (!helper.isEmpty()) {
				int ans = helper.pop();
				stack.push(ans);
			}
		}
		return;

	}

}
