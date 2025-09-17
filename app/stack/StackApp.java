package app.stack;

import amerika.stack.StackBool;

public class StackApp {

	StackBool stack = new StackBool();

	public static void main(String args[]) {
		StackApp app = new StackApp();
		app.test();
	}

	public void test() {
		stack.push(true);
		stack.push(false);
		stack.push(true);
		stack.push(true);

		System.out.println(stack.peek());
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}
