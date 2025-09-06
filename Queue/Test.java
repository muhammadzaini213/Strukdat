public class Test {

	public static void main(String args[]) {
		Queue queue = new Queue();

		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);

		System.out.println(queue.peek(0));
		System.out.println(queue.peek(1));
		System.out.println(queue.peek(2));	
		System.out.println(queue.peek(3));
		System.out.println(queue.peek(4));

		queue.swap(0,2);
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}
}
