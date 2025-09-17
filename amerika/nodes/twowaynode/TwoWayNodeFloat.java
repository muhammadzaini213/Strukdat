package amerika.nodes.twowaynode
;
import amerika.nodes.simplenode.NodeFloat;

public class TwoWayNodeFloat extends NodeFloat {

	private TwoWayNodeFloat prev;

	public TwoWayNodeFloat(float value) {
		super(value);
	}

	public void setPrev(TwoWayNodeFloat prev) {
		this.prev = prev;
	}

	public TwoWayNodeFloat getPrev() {
		return prev;
	}
}
