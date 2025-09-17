package amerika.linkedlists.onewaylinkedlist;

import amerika.nodes.simplenode.Node;
import amerika.nodes.simplenode.NodeBool;

public class LinkedListBool extends LinkedList{

	public void add(boolean value) {
		Node newNode = new NodeBool(value);
		addToLinkedList(newNode);
	}

	public void insert(boolean value, int index) {
		Node newNode = new NodeBool(value);
		insertToLinkedList(newNode, index);
	}

	public boolean get(int index) {	
		NodeBool target = (NodeBool) getLinkedListNode(index); 
		return target.getValue();

	}

}

