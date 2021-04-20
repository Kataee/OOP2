package queue;

import queue.interfaces.IQueue;

import java.util.Arrays;

public class CircularQueue implements IQueue {

    private final int CAPACITY = 10;
    private Object[] items = new Object[CAPACITY];
    private int front = -1;
    private int rear = -1;



    public boolean isEmpty() {
        return (front == -1);
    }

    @Override
    public boolean isFull() {
        if (front == 0 && rear == CAPACITY -1) {
            return true;
        }
        if (front == rear+1) {
            return true;
        }
        return false;
    }

    @Override
    public void enQueue(Object obj) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            if (front == -1) {
                front = 0;
            }
                rear = (rear+1)%CAPACITY;
                items[rear] = obj;
                System.out.println("Inserted " + obj);
        }
    }

    @Override
    public Object deQueue() {
        Object element;
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            element = items[front];
            if (front == rear) {
                front = -1;
                rear = -1;
                items[0] = null;
            } else {
                for (int i=1; i <= rear; ++i ) {
                    items[i-1] = items[i];
                }
                items[rear] = null;
                rear--;
            }
            return element;
        }
    }

    @Override
    public void printQueue() {
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
        //itt az i mehetne 0tól rear -ig, és akkor nem látjuk az üres elemeket
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true; //ha ugyan az a referencia, a cím
        if (!(o instanceof CircularQueue)) return false;
        CircularQueue that = (CircularQueue) o;
        if (items.length != that.items.length) {
            return false;
        }

        if (! Arrays.equals(this.items,that.items)) {
            return false;
        }
        if (! Arrays.deepEquals(this.items,that.items)) {
            return false;
        }
        return true;
    }
}
