public class Test {

	public static void main(String args[]) {
		Queque queque = new Queque();

		queque.enqueque(1);
		queque.enqueque(2);
		queque.enqueque(3);
		queque.enqueque(4);
		queque.enqueque(5);

		System.out.println(queque.peek(0));
		System.out.println(queque.peek(1));
		System.out.println(queque.peek(2));	
		System.out.println(queque.peek(3));
		System.out.println(queque.peek(4));

		queque.swap(0,2);
		
		System.out.println(queque.dequeque());
		System.out.println(queque.dequeque());
		System.out.println(queque.dequeque());
		System.out.println(queque.dequeque());
		System.out.println(queque.dequeque());
	}
}
