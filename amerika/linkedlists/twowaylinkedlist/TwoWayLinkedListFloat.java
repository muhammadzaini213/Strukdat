package amerika.linkedlists.twowaylinkedlist;

import amerika.nodes.simplenode.Node;
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


	public TwoWayLinkedListFloat copy(){
		TwoWayLinkedListFloat linkedList = new TwoWayLinkedListFloat();

		for (int i = 0; i < size(); i++) {
			linkedList.add(get(i));
		}

		return linkedList;
	}
	public float[] getAll() {
		float[] arr = new float[size()];
		Node[] nodeArr = (Node[]) getArray();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = ((TwoWayNodeFloat) nodeArr[i]).getValue();
		}

		return arr;
	}

}
