import amerika.nodes.simplenode.NodeBool;

public class TwoWayNodeBool extends NodeBool {

	private TwoWayNodeBool prev;

	public void setPrev(TwoWayNodeBool prev) {
		this.prev = prev;
	}

	public TwoWayNodeBool getPrev() {
		return prev;
	}
}
