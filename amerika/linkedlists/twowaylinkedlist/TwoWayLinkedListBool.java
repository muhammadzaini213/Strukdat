package amerika.linkedlists.twowaylinkedlist;

import amerika.nodes.twowaynode.TwoWayNode;
import amerika.nodes.twowaynode.TwoWayNodeBool;

public class TwoWayLinkedListBool extends TwoWayLinkedList {

    public void add(boolean value) {
        TwoWayNode newNode = new TwoWayNodeBool(value);
        addToLinkedList(newNode);
    }

    public void addLast(boolean value) {
        TwoWayNode newNode = new TwoWayNodeBool(value);
        addToLinkedListOnLast(newNode);
    }

    public void insert(boolean value, int index) {
        TwoWayNode newNode = new TwoWayNodeBool(value);
        insertToLinkedList(newNode, index);
    }

    public boolean get(int index) {
        TwoWayNodeBool target = (TwoWayNodeBool) getLinkedListNode(index);
        return target.getValue();

    }

    
    public TwoWayLinkedListBool copy(){
	TwoWayLinkedListBool linkedList = new TwoWayLinkedListBool();

	    for (int i = 0; i < size(); i++) {
		    linkedList.add(get(i));
	    }

	    return linkedList;
    }

    public boolean[] getAll() {
        boolean[] arr = new boolean[size()];
        TwoWayNode[] nodeArr = (TwoWayNode[]) getArray();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = ((TwoWayNodeBool) nodeArr[i]).getValue();
        }

        return arr;
    }

}
