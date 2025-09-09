import java.util.NoSuchElementException;

public class Queue {
	Node first, last;

	public void enqueue(int value) {
		Node newNode = new Node(value);
		if (last == null) {
			first = newNode;
        } else {
			last.setNext(newNode);
			newNode.setPrev(last);
        }
        last = newNode;
    }

	public int dequeue() {
		if (!hasItem()) {
			throw new NoSuchElementException("Queue kosong!");
		}
		int value = first.getValue();
		first = first.getNext();
		if (first != null) {
			first.setPrev(null);
		} else {
			last = null;
		}
		return value;
	}

	public void swap(int index1, int index2) {
		if (index1 == index2) return;

		if (index1 < 0 || index2 < 0) {
			throw new IndexOutOfBoundsException("Index tidak boleh negatif!");
		}

		if (index1 > index2) {
			int temp = index1;
			index1 = index2;
			index2 = temp;
		}

		Node node1 = getNode(index1);
		Node node2 = getNode(index2);

		if (node1 == null || node2 == null) {
			throw new NoSuchElementException("Index tidak ditemukan!");
		}

		Node prev1 = node1.getPrev();
		Node next1 = node1.getNext();
		Node prev2 = node2.getPrev();
		Node next2 = node2.getNext();

		if (next1 == node2) {
			if (prev1 != null) prev1.setNext(node2);
			else first = node2;

			if (next2 != null) next2.setPrev(node1);
			else last = node1;

			node2.setPrev(prev1);
			node2.setNext(node1);
			node1.setPrev(node2);
			node1.setNext(next2);
			return;
		}

		if (prev1 != null) prev1.setNext(node2);
		else first = node2;

		if (next1 != null) next1.setPrev(node2);
		else last = node2;

		if (prev2 != null) prev2.setNext(node1);
		else first = node1;

		if (next2 != null) next2.setPrev(node1);
		else last = node1;

		node1.setPrev(prev2);
		node1.setNext(next2);
		node2.setPrev(prev1);
		node2.setNext(next1);

	}

	private boolean hasItem() {
        return last != null;
    }

    public int peek() {
        if (!hasItem()) {
            throw new NoSuchElementException("Queue kosong!");
        }
        return first.getValue();
    }

	public int peek(int index) {
		if (index < 0) {
			throw new IndexOutOfBoundsException("Index negatif tidak valid!");
		}

		Node current = first;
		for (int i = 0; i < index; i++) {
            current = current.getNext();
            if (current == null) {
                throw new NoSuchElementException("Index ke-" + index + " tidak ditemukan!");
            }
		}
		return current.getValue();
	}

	private Node getNode(int index) {
		if (index < 0) {
			throw new IndexOutOfBoundsException("Index negatif tidak valid!");
		}
		Node current = first;
		for (int i = 0; i < index; i++) {
			if (current == null) return null;
			current = current.getNext();
		}
		return current;
	}
}
