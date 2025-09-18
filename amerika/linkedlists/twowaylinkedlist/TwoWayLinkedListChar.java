package amerika.linkedlists.twowaylinkedlist;

import amerika.nodes.twowaynode.TwoWayNode;
import amerika.nodes.twowaynode.TwoWayNodeChar;

public class TwoWayLinkedListChar extends TwoWayLinkedList {

    public void add(char value) {
        TwoWayNode newNode = new TwoWayNodeChar(value);
        addToLinkedList(newNode);
    }

    public void addLast(char value) {
        TwoWayNode newNode = new TwoWayNodeChar(value);
        addToLinkedListOnLast(newNode);
    }

    public void insert(char value, int index) {
        TwoWayNode newNode = new TwoWayNodeChar(value);
        insertToLinkedList(newNode, index);
    }

    public char get(int index) {
        TwoWayNodeChar target = (TwoWayNodeChar) getLinkedListNode(index);
        return target.getValue();

    }

}