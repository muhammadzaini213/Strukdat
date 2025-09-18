package app.queue;

import amerika.queue.QueueBool;

public class QueueApp {
    QueueBool queueBool = new QueueBool();

    public static void main(String[] args) {
        QueueApp app = new QueueApp();
        app.run();
    }

    public void run() {
        queueBool.enqueue(false);
        queueBool.enqueue(true);
        queueBool.enqueue(false);
        queueBool.enqueue(true);

        System.out.println(queueBool.peek());
        System.out.println(queueBool.dequeue());
        System.out.println(queueBool.dequeue());
        System.out.println(queueBool.dequeue());

    }
}
