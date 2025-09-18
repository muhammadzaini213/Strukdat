package amerika.queue;

import amerika.nodes.twowaynode.TwoWayNodeFloat;

public class QueueFloat extends Queue{
    
    public void enqueue(float value) {
        addToQueue(new TwoWayNodeFloat(value));
    }

    public float dequeue() {
        TwoWayNodeFloat out = (TwoWayNodeFloat) outFromQueue();
        return out.getValue();
    }

    public float peek() {
        TwoWayNodeFloat peek = (TwoWayNodeFloat) peekFromLast();
        return peek.getValue();
    }
}
