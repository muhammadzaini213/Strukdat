public class Node {
	Object value;
	Node next;

	public Node(Object value) {
		this.value = value;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getNext(){
		return next;
	}

	public Object getValue(){
		return value;
	}
}
