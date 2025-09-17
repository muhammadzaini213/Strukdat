package amerika.stack;

import amerika.nodes.simplenode.NodeFloat;

public class StackFloat extends Stack {

	public void push(float value) {
		pushToStack(new NodeFloat(value));
	}

	public float pop() {
		NodeFloat pop = (NodeFloat) popFromStack();
		return pop.getValue();
	}

	public float peek() {
		NodeFloat peek = (NodeFloat) peekFromStack();
		return peek.getValue();
	}
}
