package amerika.nodes.twowaynode;

import amerika.nodes.simplenode.Node;

public class TwoWayNode extends Node {
	private Node prev;

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public Node getPrev() {
		return prev;
	}
}
