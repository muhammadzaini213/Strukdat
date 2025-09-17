package amerika.stack;

import amerika.nodes.simplenode.Node;
import java.util.NoSuchElementException;
import amerika.linkedlists.onewaylinkedlist.LinkedList;

public class Stack extends LinkedList {

	public void pushToStack(Node newNode) {
		newNode.setNext(first);
		first = newNode;
		size++;
	}

	public Node popFromStack() {
		if (first == null) {
			throw new NoSuchElementException("Stack Kosong!");
		}
		Node pop = first;
		first = first.getNext();
		size--;
		return pop;
	}

	public Node peekFromStack() {	
		if (first == null) {
			throw new NoSuchElementException("Stack Kosong!");
		}

		Node peek = first;
		return first;
	}

	public boolean isEmpty() {
		return size == 0;
	}
}
