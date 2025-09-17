
package amerika.linkedlists.onewaylinkedlist;

import amerika.nodes.simplenode.Node;
import amerika.nodes.simplenode.NodeFloat;

public class LinkedListFloat extends LinkedList{

	public void add(float value) {
		Node newNode = new NodeFloat(value);
		addToLinkedList(newNode);
	}

	public void insert(float value, int index) {
		Node newNode = new NodeFloat(value);
		insertToLinkedList(newNode, index);
	}

	public float get(int index) {	
		NodeFloat target = (NodeFloat) getLinkedListNode(index); 
		return target.getValue();

	}

}
