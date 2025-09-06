public class Node {
	int value;
	Node next, prev;

	public Node (int value) {
		this.value = value;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public Node getNext() {
		return next;
	}

	public Node getPrev() {
		return prev;
	}

	public int getValue() {
		return value;
	}
}
