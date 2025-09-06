public class Queque {
	Node first, last;

	public void enqueque(int value) {
		Node newNode = new Node(value);
		if (last == null) {
			first = newNode;
			last = newNode;
		} else {
			last.setNext(newNode);
			newNode.setPrev(last);
			last = newNode;
		}
	}

	public int dequeque() {
		if (!hasItem()) {
			throw new IllegalStateException("Queque kosong!");
		}

		int value = last.getValue();
		Node prevNode = last.getPrev();
		last.setPrev(null);
		last = prevNode;
		return value;
	}

	public void swap(int index1, int index2) {
		if (index1 == index2) return;

		if (index1 > index2) {
			int temp = index1;
			index1 = index2;
			index2 = temp;
		}

		try {
			if (index1 < 0) {
				throw new IndexOutOfBoundsException("Index tidak bisa negatif!");
			}

			Node node1 = getNode(index1);
			Node node2 = getNode(index2);
			if (node2 == null) {
				throw new IndexOutOfBoundsException("Index ke-" + index2 + "tidak ditemukan!");
			}

			Node tempPrev1;
			if (node1 == first) {
				tempPrev1 = null;
			} else {
				tempPrev1 = node1.getPrev();
                        }

			Node tempNext1 = node1.getNext();
			Node tempNext2 = node2.getNext();
			Node tempPrev2 = node2.getPrev();
			if (tempNext1 == node2) {
				node1.setNext(tempNext2);
				node2.setNext(node1);
				node1.setPrev(node2);
				if(tempPrev1 != null) {
					tempPrev1.setNext(node2);
					node2.setNext(tempPrev1);

				} else {
					first = node2;
				}
			}

			if (last == node2) {
				last = node1;
			}

			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private boolean hasItem() {
		if (last != null) {
			return true;
		}
		return false;
	}

	public int peek(int index) {
		if (index < 0) {
			throw new IndexOutOfBoundsException("Mana ada index negatif!");
		}

		Node current = last;

		for (int i = 0; i < index; i++) {
			current = current.getPrev();
		}
		return current.getValue();
	}

	private Node getNode(int index) {
		if (index < 0) {
			throw new IndexOutOfBoundsException("Mana ada index negatif!");                             }                                 
		Node current = last;
		for (int i = 0; i < index; i++) {                         current = current.getPrev();                                                                }                 
		return current;
	}
}
