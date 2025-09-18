package amerika.queue;

import java.util.NoSuchElementException;

import amerika.linkedlists.twowaylinkedlist.TwoWayLinkedList;
import amerika.nodes.simplenode.Node;
import amerika.nodes.twowaynode.TwoWayNode;

public class Queue extends TwoWayLinkedList{

    public void addToQueue(TwoWayNode newNode) {
		addToLinkedList(newNode);
	}

	public Node outFromQueue() {
		if (last == null) {
			throw new NoSuchElementException("Queue Kosong!");
		}
		Node out = last;
		last = (TwoWayNode) last.getPrev();
		size--;
		return out;
	}

	public Node peekFromLast() {	
		if (last == null) {
			throw new NoSuchElementException("Queue Kosong!");
		}

		Node peek = last;
		return peek;
	}

	public boolean isEmpty() {
		return size == 0;
	}
}
