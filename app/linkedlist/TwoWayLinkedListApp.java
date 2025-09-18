package app.linkedlist;

import amerika.linkedlists.twowaylinkedlist.TwoWayLinkedListInt;

public class TwoWayLinkedListApp {

    TwoWayLinkedListInt linkedListInt = new TwoWayLinkedListInt();

    public static void main(String[] args) {
        TwoWayLinkedListApp app = new TwoWayLinkedListApp();
        app.run();
    }

    public void run() {
        linkedListInt.add(10);
        linkedListInt.add(12);
        linkedListInt.add(45);
        linkedListInt.add(15);

        linkedListInt.addLast(1000);

        System.out.println(linkedListInt.get(0));
        System.out.println(linkedListInt.get(1));
        System.out.println(linkedListInt.get(2));
        System.out.println(linkedListInt.get(3));
        System.out.println(linkedListInt.get(4));

    }
}
