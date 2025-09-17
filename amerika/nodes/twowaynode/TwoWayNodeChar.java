import amerika.nodes.simplenode.NodeChar;

public class TwoWayNodeChar extends NodeChar {

	private TwoWayNodeChar prev;

	public void setPrev(TwoWayNodeChar prev) {
		this.prev = prev;
	}

	public TwoWayNodeChar getPrev() {
		return prev;
	}
}
