package amerika.nodes.simplenode;

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

	public boolean getValue(){
		return value;
	}
}
