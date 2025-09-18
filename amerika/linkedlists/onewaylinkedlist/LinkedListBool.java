package amerika.linkedlists.onewaylinkedlist;

import amerika.nodes.simplenode.Node;
import amerika.nodes.simplenode.NodeBool;

public class LinkedListBool extends LinkedList {

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

	public boolean[] getAll() {
		boolean[] arr = new boolean[size()];
		Node[] nodeArr = (Node[]) getArray();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = ((NodeBool) nodeArr[i]).getValue();
		}

		return arr;
	}

}
