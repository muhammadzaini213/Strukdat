package amerika.nodes.twowaynode;

import amerika.nodes.simplenode.NodeFloat;

public class TwoWayNodeFloat extends TwoWayNode {
	private float value;

	public TwoWayNodeFloat(float value) {
		this.value = value;
	}

	public float getValue() {
		return value;
	}
}
