package amerika.linkedlists.twowaylinkedlist;

import amerika.nodes.simplenode.Node;
import amerika.nodes.twowaynode.TwoWayNode;
import amerika.nodes.twowaynode.TwoWayNodeInt;

public class TwoWayLinkedListInt extends TwoWayLinkedList {

    public void add(int value) {
        TwoWayNode newNode = new TwoWayNodeInt(value);
        addToLinkedList(newNode);
    }

    public void addLast(int value) {
        TwoWayNode newNode = new TwoWayNodeInt(value);
        addToLinkedListOnLast(newNode);
    }

    public void insert(int value, int index) {
        TwoWayNode newNode = new TwoWayNodeInt(value);
        insertToLinkedList(newNode, index);
    }

    public int get(int index) {
        TwoWayNodeInt target = (TwoWayNodeInt) getLinkedListNode(index);
        return target.getValue();

    }

    public int[] getAll() {
        int[] arr = new int[size()];
        Node[] nodeArr = (Node[]) getArray();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = ((TwoWayNodeInt) nodeArr[i]).getValue();
        }

        return arr;
    }

}