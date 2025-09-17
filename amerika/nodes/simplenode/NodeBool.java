package amerika.nodes.simplenode;

public class NodeBool extends Node{
	private boolean value;

	public NodeBool(boolean value) {
		this.value = value;
	}

	public boolean getValue(){
		return value;
	}
}
