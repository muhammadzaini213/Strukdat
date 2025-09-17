package amerika.stack;

import amerika.nodes.simplenode.NodeBool;

public class StackBool extends Stack {

	public void push(boolean value) {
		pushToStack(new NodeBool(value));
	}

	public boolean pop() {
		NodeBool pop = (NodeBool) popFromStack();
		return pop.getValue();
	}

	public boolean peek() {
		NodeBool peek = (NodeBool) peekFromStack();
		return peek.getValue();
	}

}
