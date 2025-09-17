package amerika.nodes.simplenode;

public class NodeInt{
	private int value;
	private NodeInt next;

	public NodeInt(int value) {
		this.value = value;
	}

	public void setNext(NodeInt next) {
		this.next = next;
	}

	public NodeInt getNext(){
		return next;
	}

	public int getValue(){
		return value;
	}
}
