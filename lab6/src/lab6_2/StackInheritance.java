package lab6_2;

import java.util.ArrayList;

public class StackInheritance extends ArrayList<Integer> {
    private int capacity;

    public StackInheritance(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFull () {
        return capacity == size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void push(int item) {
        add(item);
    }

    public void pop() {
        remove(size()-1);
    }

    public int top() {
        return get(size()-1);
    }

    public int getSize() {
        return size();
    }



}
