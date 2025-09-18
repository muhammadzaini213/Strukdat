package amerika.nodes.twowaynode;

import amerika.nodes.simplenode.NodeChar;

public class TwoWayNodeChar extends TwoWayNode {
	private char value;

	public TwoWayNodeChar(char value) {
		this.value = value;
	}

	public char getValue() {
		return value;
	}
}
