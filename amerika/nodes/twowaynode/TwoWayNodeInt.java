package amerika.nodes.twowaynode;

import amerika.nodes.simplenode.NodeInt;

public class TwoWayNodeInt extends TwoWayNode {
	private int value;

	public TwoWayNodeInt(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
