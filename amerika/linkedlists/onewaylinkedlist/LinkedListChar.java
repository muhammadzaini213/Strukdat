package amerika.linkedlists.onewaylinkedlist;

import amerika.nodes.simplenode.Node;
import amerika.nodes.simplenode.NodeChar;

public class LinkedListChar extends LinkedList{

	public void add(char value) {
		Node newNode = new NodeChar(value);
		addToLinkedList(newNode);
	}

	public void insert(char value, int index) {
		Node newNode = new NodeChar(value);
		insertToLinkedList(newNode, index);
	}

	public char get(int index) {	
		NodeChar target = (NodeChar) getLinkedListNode(index); 
		return target.getValue();

	}

}

