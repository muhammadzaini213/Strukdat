package amerika.linkedlists.onewaylinkedlist;

import amerika.nodes.simplenode.Node;
import amerika.nodes.simplenode.NodeChar;

public class LinkedListChar extends LinkedList {

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


	public LinkedList copy() {
		LinkedListChar linkedList = new LinkedListChar();

		for (int i = 0; i < size(); i++) {
			linkedList.add(get(i));
		}

		return linkedList;
	}
	public char[] getAll() {
		char[] arr = new char[size()];
		Node[] nodeArr = (Node[]) getArray();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = ((NodeChar) nodeArr[i]).getValue();
		}

		return arr;
	}

}
