
package amerika.linkedlists.onewaylinkedlist;

import amerika.nodes.simplenode.Node;
import amerika.nodes.simplenode.NodeFloat;
import amerika.nodes.simplenode.NodeInt;

public class LinkedListInt extends LinkedList {

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

	public int[] getAll() {
		int[] arr = new int[size()];
		Node[] nodeArr = getArray();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = ((NodeInt) nodeArr[i]).getValue();
		}

		return arr;
	}

}
