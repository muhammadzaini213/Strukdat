package amerika.queue;

import amerika.nodes.twowaynode.TwoWayNodeInt;

public class QueueInt extends Queue{
    
    public void enqueue(int value) {
        addToQueue(new TwoWayNodeInt(value));
    }

    public int dequeue() {
        TwoWayNodeInt out = (TwoWayNodeInt) outFromQueue();
        return out.getValue();
    }

    public int peek() {
        TwoWayNodeInt peek = (TwoWayNodeInt) peekFromLast();
        return peek.getValue();
    }
}
