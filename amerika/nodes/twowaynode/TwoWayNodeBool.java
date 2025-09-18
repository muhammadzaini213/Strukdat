package amerika.nodes.twowaynode;

import amerika.nodes.simplenode.NodeBool;

public class TwoWayNodeBool extends TwoWayNode {
	private boolean value;

	public TwoWayNodeBool(boolean value) {
		this.value = value;
	}

	public boolean getValue() {
		return value;
	}
}
