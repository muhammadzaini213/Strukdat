
package amerika.linkedlists.onewaylinkedlist;

import amerika.nodes.simplenode.Node;
import amerika.nodes.simplenode.NodeInt;

public class LinkedListInt extends LinkedList{

	public void add(int value) {
		Node newNode = new NodeInt(value);
		addToLinkedList(newNode);
	}

	public void insert(int value, int index) {
		Node newNode = new NodeInt(value);
		insertToLinkedList(newNode, index);
	}

	public int get(int index) {	
		NodeInt target = (NodeInt) getLinkedListNode(index); 
		return target.getValue();

	}

}
