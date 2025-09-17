public class NodeBool{
	private boolean value;
	private NodeBool next;

	public NodeBool(boolean value) {
		this.value = value;
	}

	public void setNext(NodeBool next) {
		this.next = next;
	}

	public NodeBool getNext(){
		return next;
	}

	public int getValue(){
		return value;
	}
}
