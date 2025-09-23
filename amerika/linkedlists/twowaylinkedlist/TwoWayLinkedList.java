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
		if (size == 0) {
			updateFirst((TwoWayNode) newNode);
			last = (TwoWayNode) newNode;
			size++;
			return;
		}

		if (index == 0) {
			newNode.setNext(first);
			first.setPrev(newNode);
			updateFirst((TwoWayNode) newNode);
			size++;
			return;
		}

		if (index == size) {
			((TwoWayNode) last).setNext(newNode);
			((TwoWayNode) newNode).setPrev(last);
			last = (TwoWayNode) newNode;
			size++;
			return;
		}

		TwoWayNode nextNode = (TwoWayNode) getNode(index);
		TwoWayNode prevNode = (TwoWayNode) nextNode.getPrev();

		prevNode.setNext(newNode);
		((TwoWayNode) newNode).setPrev(prevNode);

		newNode.setNext(nextNode);
		nextNode.setPrev(newNode);
		size++;
	}
	protected Node getNode(int index) {
		if (first == null) {
			throw new java.util.NoSuchElementException("LinkedList kosong!");
		}
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Tidak ada index valid: " + index);
		}

		TwoWayNode target;

		if (index < size / 2) {
			target = first;
			for (int i = 0; i < index; i++) {
				target = (TwoWayNode) target.getNext();
			}
		} else {
			target = last;
			for (int i = size - 1; i > index; i--) {
				target = (TwoWayNode) target.getPrev();
			}
		}

		return target;
	}

	protected TwoWayNode getLinkedListNode(int index) {
		if (first == null) {
			throw new java.util.NoSuchElementException("LinkedList kosong!");
		}
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Tidak ada index valid: " + index);
		}

		TwoWayNode target;

		if (index < size / 2) {
			target = first;
			for (int i = 0; i < index; i++) {
				target = (TwoWayNode) target.getNext();
			}
		} else {
			target = last;
			for (int i = size - 1; i > index; i--) {
				target = (TwoWayNode) target.getPrev();
			}
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

		if (index1 < 0 || index2 < 0 || index1 >= size || index2 >= size) {
			throw new IndexOutOfBoundsException("Index di luar batas!");
		}

		if (index1 > index2) { // urutkan index biar konsisten
			int temp = index1;
			index1 = index2;
			index2 = temp;
		}

		TwoWayNode node1 = (TwoWayNode) getNode(index1);
		TwoWayNode node2 = (TwoWayNode) getNode(index2);

		if (node1 == null || node2 == null) {
			throw new IllegalStateException("Node tidak ditemukan!");
		}

		TwoWayNode prev1 = (TwoWayNode) node1.getPrev();
		TwoWayNode prev2 = (TwoWayNode) node2.getPrev();

		TwoWayNode next1 = (TwoWayNode) node1.getNext();
		TwoWayNode next2 = (TwoWayNode) node2.getNext();

		// Kasus: node1 dan node2 bersebelahan
		if (next1 == node2) {
			if (prev1 != null) {
				prev1.setNext(node2);
				node2.setPrev(prev1);
			} else {
				first = node2;        // node2 jadi head baru
				node2.setPrev(null);
			}

			node2.setNext(node1);
			node1.setPrev(node2);

			node1.setNext(next2);
			if (next2 != null) {
				next2.setPrev(node1);
			} else {
				last = node1;         // node1 jadi tail baru
			}

			return;
		}

		// Node tidak bersebelahan
		if (prev1 != null) {
			prev1.setNext(node2);
		} else {
			first = node2;            // node2 jadi head baru
		}

		if (next1 != null) {
			next1.setPrev(node2);
		} else {
			last = node2;             // node2 jadi tail baru
		}

		if (prev2 != null) {
			prev2.setNext(node1);
		} else {
			first = node1;            // node1 jadi head baru
		}

		if (next2 != null) {
			next2.setPrev(node1);
		} else {
			last = node1;             // node1 jadi tail baru
		}

		// Tukar next/prev pointer node1 dan node2
		TwoWayNode tempPrev = (TwoWayNode) node1.getPrev();
		TwoWayNode tempNext = (TwoWayNode) node1.getNext();

		node1.setPrev(node2.getPrev());
		node1.setNext(node2.getNext());

		node2.setPrev(tempPrev);
		node2.setNext(tempNext);
	}
	public void clear() {
		updateFirst(null);
		last = null;
		size = 0;
	}
}
