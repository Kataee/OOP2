package queue.interfaces;

public interface IQueue {

    boolean isEmpty();
    boolean isFull();
    void enQueue(Object obj);
    Object deQueue();
    void printQueue();
}
