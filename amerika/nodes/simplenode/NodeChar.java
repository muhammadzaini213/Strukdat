package amerika.nodes.simplenode;

public class NodeChar{
	private char value;
	private NodeChar next;

	public NodeChar(char value) {
		this.value = value;
	}

	public void setNext(NodeChar next) {
		this.next = next;
	}

	public NodeChar getNext(){
		return next;
	}

	public char getValue(){
		return value;
	}
}
