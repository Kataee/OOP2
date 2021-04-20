package queue;

import queue.interfaces.IQueue;

import java.util.ArrayList;

public class ArrayListQueue implements IQueue {

    private final int CAPACITY = 10;
    private ArrayList<Object> items = new ArrayList<>(CAPACITY);


    @Override
    public boolean isEmpty() {
        return this.items.size() == 0;
    }

    @Override
    public boolean isFull() {
        return this.items.size() == CAPACITY;
    }

    @Override
    public void enQueue(Object obj) {
        if (this.items.size() <= CAPACITY ) {
            items.add(obj);
        } else {
            System.out.println("Cannot add more items");
        }

    }


    //??? ha null -t térítek vissza, hibát kapok, tehát a size nagyobb kell legyen 1nél
    //hogy tudjak törölni és mégis maradjon valami amit visszatérítsek és nem 0
    @Override
    public Object deQueue() {
        if (!(this.items.size() < 2)) {
            this.items.remove(0);
            return this.items.get(0);
        } else {
            System.out.println("The queue is empty, cannot remove");
            return items.get(0);
        }
    }

    @Override
    public void printQueue() {
        for (Object item : items) {
            System.out.println(item);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; //ha ugyan az a referencia, a cím
        if (!(o instanceof ArrayListQueue)) return false;
        ArrayListQueue that = (ArrayListQueue) o;
        if (items.size() != that.items.size()) {
            return false;
        }
        for (int i=0; i < items.size(); ++i) {
            if (!items.get(i).equals(that.items.get(i))) {
                return false;
            }
        }
        return true;
    }

}
