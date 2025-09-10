public class Node {
	Object value;
	Node next, prev;

	public Node (Object value) {
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

	public Object getValue() {
		return value;
	}
}
