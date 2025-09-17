package amerika.stack;

import amerika.nodes.simplenode.NodeChar;

public class StackChar extends Stack {

	public void push(char value) {
		pushToStack(new NodeChar(value));
	}

	public char pop() {
		NodeChar pop = (NodeChar) popFromStack();
		return pop.getValue();
	}

	public char peek() {
		NodeChar peek = (NodeChar) peekFromStack();
		return peek.getValue();
	}
}
