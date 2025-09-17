package amerika.linkedlists.onewaylinkedlist;

import amerika.nodes.simplenode.NodeBool;

public class LinkedListBool {

	private NodeBool first;
	private int size = 0;

	public void add(boolean value) {
		NodeBool newNode = new NodeBool(value);
		newNode.setNext(first);
		first = newNode;
		size++;
	}

	public void insert(boolean value, int index) {
		NodeBool newNode = new NodeBool(value);
		NodeBool prevNode = getNode(index - 1);
		NodeBool nextNode = getNode(index);
		
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

		NodeBool prevNode = getNode(index - 1);
		NodeBool nextNode = getNode(index + 1);

		if (nextNode == null) {
			NodeBool currentNode = getNode(index);
			prevNode.setNext(null);
			size--;
			return;
		}

		prevNode.setNext(nextNode);
		size--;
	}



	public void swap (int index1, int index2) {
		if (index1 == index2) return;

		if (index1 > index2) {
			int temp = index1;
			index1 = (index2);
			index2 = temp;
		}

		try {
			if (index1 < 0) {
				throw new IndexOutOfBoundsException("Tidak ada index negatif!");
			}
			NodeBool node1 = getNode(index1);
			NodeBool node2 = getNode(index2);

			if (node2 == null || index2 >= size) {
				throw new IndexOutOfBoundsException("Index ke-" + index2 + " tidak ditemukan!");

			}

			NodeBool tempPrev1;
			if (node1 == first) {
				tempPrev1 = null;
			} else {
				tempPrev1 = getNode(index1-1);
			}

			NodeBool tempNext1 = node1.getNext();

			NodeBool tempNext2 = node2.getNext();
			NodeBool tempPrev2 = getNode(index2-1);
			if (tempNext1 == node2) {
				node1.setNext(tempNext2);
				node2.setNext(node1);

				if (tempPrev1 != null) {
					tempPrev1.setNext(node2);
				} else {
					first = node2;
				}
				return;
			}
			node2.setNext(tempNext1);

			tempPrev2.setNext(node1);

			node1.setNext(tempNext2);

			if (tempPrev1 != null) {
				tempPrev1.setNext(node2);
			} else {
				first = node2;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private NodeBool getNode(int index) {
		NodeBool target = first;
		int i = 0;
		while (i < index && target != null) {
			target = target.getNext();
			i++;
		}
		return target;
	}

	public boolean get(int index) {
		if (first == null) {
			throw new java.util.NoSuchElementException("Stack kosong!");
		}
		if (index < 0) {
			throw new IndexOutOfBoundsException("Tidak ada index negatif!");
		}
		NodeBool target = first;
		int i = 0;
		while (i < index && target != null) {
			target = target.getNext();
			i++;
		}
		if (target == null || index >= size) {
			throw new IndexOutOfBoundsException("Value dengan index ke-" + index +" tidak ditemukan");
		}
		return target.getValue();

	}

	public int size() {
		return size;
	}
}

