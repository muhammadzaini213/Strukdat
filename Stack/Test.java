public class Test {

	public static void main(String args[]) {
		Stack myStack = new Stack();

		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		myStack.push(4);
		myStack.push(5);
		myStack.push(6);

		//System.out.println(myStack.peek(0));
		//System.out.println(myStack.peek(1));
		//System.out.println(myStack.peek(2));
		//System.out.println(myStack.peek(4));
		myStack.swap(2,3);
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
	}
}
