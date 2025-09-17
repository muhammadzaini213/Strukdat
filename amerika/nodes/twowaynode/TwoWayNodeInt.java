import amerika.nodes.simplenode.NodeInt;

public class TwoWayNodeInt extends NodeInt {

	private TwoWayNodeInt prev;

	public void setPrev(TwoWayNodeInt prev) {
		this.prev = prev;
	}

	public TwoWayNodeInt getPrev() {
		return prev;
	}
}
