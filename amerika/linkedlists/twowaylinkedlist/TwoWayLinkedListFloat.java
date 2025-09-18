package amerika.linkedlists.twowaylinkedlist;

import amerika.nodes.twowaynode.TwoWayNode;
import amerika.nodes.twowaynode.TwoWayNodeFloat;

public class TwoWayLinkedListFloat extends TwoWayLinkedList {

    public void add(float value) {
        TwoWayNode newNode = new TwoWayNodeFloat(value);
        addToLinkedList(newNode);
    }

    public void addLast(float value) {
        TwoWayNode newNode = new TwoWayNodeFloat(value);
        addToLinkedListOnLast(newNode);
    }

    public void insert(float value, int index) {
        TwoWayNode newNode = new TwoWayNodeFloat(value);
        insertToLinkedList(newNode, index);
    }

    public float get(int index) {
        TwoWayNodeFloat target = (TwoWayNodeFloat) getLinkedListNode(index);
        return target.getValue();

    }

}