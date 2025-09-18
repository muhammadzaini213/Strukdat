package amerika.linkedlists.twowaylinkedlist;

import amerika.linkedlists.onewaylinkedlist.LinkedList;
import amerika.nodes.simplenode.Node;
import amerika.nodes.twowaynode.TwoWayNode;

public class TwoWayLinkedList extends LinkedList {

	protected TwoWayNode first, last;

	protected void updateFirst(TwoWayNode newNode) {
		this.first = newNode;
		super.first = newNode;
	}

	protected void addToLinkedList(TwoWayNode newNode) {
		if(this.first == null) {
			updateFirst(newNode);
			last = newNode;
			size++;
			return;
		}

		newNode.setNext(first);
		first.setPrev(newNode);
		updateFirst(newNode);		
		size++;
	}

	protected void addToLinkedListOnLast(TwoWayNode newNode) {
		if(this.first == null) {
			updateFirst(newNode); 
			last = newNode;
			size++;
			return;
		}

		last.setNext(newNode);
		newNode.setPrev(last);
		last = newNode;
		size++;
	}

	protected void insertToLinkedList(Node newNode, int index) {
		TwoWayNode nextNode = (TwoWayNode) getNode(index);
		TwoWayNode prevNode = (TwoWayNode) nextNode.getPrev();

		if (size == 0) {
			updateFirst(newNode);
			last = newNode;
			size++;
			return;
		}

		if(index == 0) {
			newNode.setNext(first);
			first.setPrev(newNode);
			updateFirst(newNode);
			size++;
			return;
		}

		if(index == size) {
			prevNode.setNext(newNode);
			newNode.setPrev(prevNode);
			last = newNode;
			size++;
			return;
		}

		prevNode.setNext(newNode);
		newNode.setPrev(prevNode);

		newNode.setNext(nextNode);
		nextNode.setPrev(newNode);
		size++;
	}


	public void remove(int index) {
		if (size == 0) {
			throw new java.util.NoSuchElementException("LinkedList Kosong!");
		}
		if (index >= size) {
			throw new java.util.NoSuchElementException("Index ke-" + index + " tidak ditemukan!");
		}

		TwoWayNode currentNode = (TwoWayNode) getNode(index);

		TwoWayNode prevNode = (TwoWayNode) currentNode.getPrev();
		TwoWayNode nextNode = (TwoWayNode) currentNode.getNext();

		if (index == 0) {
			updateFirst(nextNode);
			size--;
			return;
		}

		if (nextNode == null) {
			prevNode.setNext(null);
			last = prevNode;
			size--;
			return;
		}

		prevNode.setNext(nextNode);
		nextNode.setPrev(prevNode);
		size--;
	}

	public void swap(int index1, int index2) {
		if (index1 == index2) return;

		if (index1 < 0 || index2 < 0 || || index1 >= size || index2 >= size) {
			throw new IndexOutOfBoundsException("Index di luar batas!");
		}

		if (index1 > index2) {
			int temp = index1;
			index1 = index2;
			index2 = temp;
		}

		TwoWayNode node1 = (TwoWayNode) getNode(index1);
		TwoWayNode node2 = (TwoWayNode) getNode(index2);

		TwoWayNode prev1 = (TwoWayNode) node1.getPrev();
		TwoWayNode prev2 = (TwoWayNode) node2.getPrev();

		TwoWayNode next1 = (TwoWayNode) node1.getNext();
		TwoWayNode next2 = (TwoWayNode) node2.getNext();

		if (next1 == node2) {
			if (prev1 != null) {
				prev1.setNext(node2);
				node2.setPrev(prev1);
			} else {
				first = node2;
			}
			
			node2.setNext(node1);
			node1.setPrev(node2);

			node1.setNext(next2);
			next2.setPrev(node1);
			return;
		}

		if (prev1 -= null) {
			prev1.setNext(node2);
			node2.setPrev(prev1);
		} else {
			first = node2:
		}

		if (prev2 != null) {
			prev2.setNext(node1);
			node1.setPrev(prev2);
		} else {
			first = node1;
		}

		node1.setNext(next2);
		next2.setPrev(node1);

		node2.setNext(next1);
		next1.setPrev(node2);
	}

	public void clear() {
		updateFirst(null);
		last = null;
		size = 0;
	}
}
