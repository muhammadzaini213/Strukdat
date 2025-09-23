
package amerika.linkedlists.onewaylinkedlist;

import amerika.nodes.simplenode.Node;
import amerika.nodes.simplenode.NodeChar;
import amerika.nodes.simplenode.NodeFloat;

public class LinkedListFloat extends LinkedList {

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


	public LinkedList copy() {
		LinkedListFloat linkedList = new LinkedListFloat();

		for (int i = 0; i < size(); i++) {
			linkedList.add(get(i));
		}

		return linkedList;
	}
	public float[] getAll() {
		float[] arr = new float[size()];
		Node[] nodeArr = (Node[]) getArray();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = ((NodeFloat) nodeArr[i]).getValue();
		}

		return arr;
	}

}
