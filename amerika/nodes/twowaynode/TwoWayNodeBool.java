
package amerika.nodes.twowaynode;

import amerika.nodes.simplenode.NodeBool;

public class TwoWayNodeBool extends NodeBool {

	private TwoWayNodeBool prev;

	public TwoWayNodeBool(boolean value) {
		super(value);
	}
	
	public void setPrev(TwoWayNodeBool prev) {
		this.prev = prev;
	}

	public TwoWayNodeBool getPrev() {
		return prev;
	}
}
