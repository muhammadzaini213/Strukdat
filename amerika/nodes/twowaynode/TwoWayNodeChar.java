package amerika.nodes.twowaynode;

import amerika.nodes.simplenode.NodeChar;

public class TwoWayNodeChar extends NodeChar {

	private TwoWayNodeChar prev;

	public TwoWayNodeChar(char value) {
		super(value);
	}
	
	public void setPrev(TwoWayNodeChar prev) {
		this.prev = prev;
	}

	public TwoWayNodeChar getPrev() {
		return prev;
	}
}
