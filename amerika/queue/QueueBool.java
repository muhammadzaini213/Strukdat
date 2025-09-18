package amerika.queue;

import amerika.nodes.twowaynode.TwoWayNodeBool;

public class QueueBool extends Queue{
    
    public void enqueue(boolean value) {
        addToQueue(new TwoWayNodeBool(value));
    }

    public boolean dequeue() {
        TwoWayNodeBool out = (TwoWayNodeBool) outFromQueue();
        return out.getValue();
    }

    public boolean peek() {
        TwoWayNodeBool peek = (TwoWayNodeBool) peekFromLast();
        return peek.getValue();
    }
}
