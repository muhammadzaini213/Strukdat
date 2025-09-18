package amerika.queue;

import amerika.nodes.twowaynode.TwoWayNodeChar;

public class QueueChar extends Queue{
    
    public void enqueue(char value) {
        addToQueue(new TwoWayNodeChar(value));
    }

    public char dequeue() {
        TwoWayNodeChar out = (TwoWayNodeChar) outFromQueue();
        return out.getValue();
    }

    public char peek() {
        TwoWayNodeChar peek = (TwoWayNodeChar) peekFromLast();
        return peek.getValue();
    }
}
