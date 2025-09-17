public class NodeFloat{
	private float value;
	private NodeFloat next;

	public NodeFloat(float value) {
		this.value = value;
	}

	public void setNext(NodeFloat next) {
		this.next = next;
	}

	public NodeFloat getNext(){
		return next;
	}

	public float getValue(){
		return value;
	}
}
