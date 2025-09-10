public class Test {

    public static void main(String args[]) {
        Stack myStack = new Stack();

        System.out.println("=== Mengisi Data ===");
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);

        System.out.println("\n=== Peek Data from Index 0..4 ===");
        for (int i = 0; i < 5; i++) {
            System.out.println(myStack.peek(i));
        }

        System.out.println("\n=== Pop Data ===");
        while (myStack.hasPop()) {
            System.out.println(myStack.pop());
        }

        // isi ulang biar bisa swap
        System.out.println("\n=== Mengisi Data ===");
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);

        System.out.println("\n=== Swap Data ===");
        System.out.println("1, 2, 3, 4, 5");
        System.out.println("      ^  ^   ");
        myStack.swap(2, 3);

        System.out.println("\n=== Pop Data ===");
        while (myStack.hasPop()) {
            System.out.println(myStack.pop());
        }

        System.out.println("\n=== Attempt to Peek Empty Stack ===");
        try {
            System.out.println(myStack.peek(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
