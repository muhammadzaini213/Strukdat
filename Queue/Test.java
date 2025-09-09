public class Test {

	public static void main(String args[]) {
		Queue queue = new Queue();

        System.out.println("=== Mengisi Data ===");
		queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println("\n=== Peek Data from Index 0..4 ===");
        System.out.println(queue.peek(0));
        System.out.println(queue.peek(1));
        System.out.println(queue.peek(2));
        System.out.println(queue.peek(3));
        System.out.println(queue.peek(4));

        System.out.println("\n=== Dequeue Data ===");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        System.out.println("=== Mengisi Data ===");
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println("\n=== Swap Data ===");
        queue.swap(0,2);

        System.out.println("\n=== Dequeue Data ===");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        System.out.println("\n=== Attempt to Peek Empty Queue ===");
        System.out.println(queue.peek());
	}
}
