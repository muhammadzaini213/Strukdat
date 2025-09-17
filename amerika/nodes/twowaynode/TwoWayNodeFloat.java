import amerika.nodes.simplenode.NodeFloat;

public class TwoWayNodeFloat extends NodeFloat {

	private TwoWayNodeFloat prev;

	public void setPrev(TwoWayNodeFloat prev) {
		this.prev = prev;
	}

	public TwoWayNodeFloat getPrev() {
		return prev;
	}
}
