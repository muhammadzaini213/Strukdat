package amerika.stack;

import amerika.nodes.simplenode.NodeInt;

public class StackInt extends Stack {

	public void push(int value) {
		pushToStack(new NodeInt(value));
	}

	public int pop() {
		NodeInt pop = (NodeInt) popFromStack();
		return pop.getValue();
	}

	public int peek() {
		NodeInt peek = (NodeInt) peekFromStack();
		return peek.getValue();
	}
}
