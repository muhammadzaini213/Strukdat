package amerika.linkedlists.onewaylinkedlist;

import amerika.nodes.simplenode.Node;


public class LinkedList {

	protected Node first;
	protected int size = 0;

	protected void addToLinkedList(Node newNode) {
		Node currentNode = first;

		if (first == null) {
			first = newNode;
			size++;
			return;
		}

		while(currentNode.getNext() != null) {
			currentNode = currentNode.getNext();
		}

		currentNode.setNext(newNode);
		size++;
	}

	protected void insertToLinkedList(Node newNode, int index) {
		Node nextNode = getNode(index);
		Node prevNode = getNode(index - 1);
		if(index == 0){
			newNode.setNext(first);
			first = newNode;
			size++;
			return;
		}

		if(index == size) {
			prevNode.setNext(newNode);
			size++;
			return;
		}

		prevNode.setNext(newNode);
		newNode.setNext(nextNode);
		size++;

	}

	protected Node getLinkedListNode(int index) {
		if (first == null) {
			throw new java.util.NoSuchElementException("LinkedList kosong!");
		}
		if (index < 0) {
			throw new IndexOutOfBoundsException("Tidak ada index negatif!");
		}
		Node target =  first;
		int i = 0;
		while (i < index && target != null) {
			target = target.getNext();
			i++;
		}
		if (target == null || index >= size) {
			throw new IndexOutOfBoundsException("Value dengan index ke-" + index +" tidak ditemukan");
		}

		return target;
	}

	public void remove(int index) {
		if (size == 0) {
			throw new java.util.NoSuchElementException("LinkedList Kosong!");
		}
		if (index >= size) {
			throw new java.util.NoSuchElementException("Index ke-" + index + " tidak ditemukan!");
		}

		if (index == 0) {
			first = getNode(1);
			size--;
			return;
		}

		Node prevNode = getNode(index - 1);
		Node nextNode = getNode(index + 1);

		if (nextNode == null) {
			prevNode.setNext(null);
			size--;
			return;
		}

		prevNode.setNext(nextNode);
		size--;
	}

	public void swap(int index1, int index2) {
		if (index1 == index2) return;

		if (index1 < 0 || index2 < 0 || index1 >= size || index2 >= size) {
			throw new IndexOutOfBoundsException("Index di luar batas!");
		}

		if (index1 > index2) {
			int temp = index1;
			index1 = index2;
			index2 = temp;
		}

		Node node1 = getNode(index1);
		Node node2 = getNode(index2);

		Node prev1 = (index1 > 0) ? getNode(index1 - 1) : null;
		Node prev2 = (index2 > 0) ? getNode(index2 - 1) : null;
		Node next1 = node1.getNext();
		Node next2 = node2.getNext();

		if (next1 == node2) {
			if (prev1 != null) prev1.setNext(node2);
			else first = node2;

			node2.setNext(node1);
			node1.setNext(next2);
			return;
		}

		if (prev1 != null) prev1.setNext(node2);
		else first = node2;

		if (prev2 != null) prev2.setNext(node1);
		else first = node1;

		node1.setNext(next2);
		node2.setNext(next1);
	}


	protected Node getNode(int index) {
		Node target = first;
		int i = 0;
		while (i < index && target != null) {
			target = target.getNext();
			i++;
		}
		return target;
	}

	public int size() {
		return size;
	}

	public void clear() {
		first = null;
		size = 0;
	}
}

