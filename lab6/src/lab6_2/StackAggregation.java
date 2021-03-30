package lab6_2;

import java.util.ArrayList;

public class StackAggregation {
    private ArrayList<Integer> items = new ArrayList<>();
    private int capacity;

    public StackAggregation (int capacity) {
        this.capacity = capacity;
    }

    public boolean isFull() {
        return items.size() == capacity;
    }

    public boolean isEmpty() {
        return items.size() == 0;
    }

    public void push(int item) {
        items.add(item);
    }

    public void pop() {
        items.remove(items.size()-1);
    }

    public int top() {
        return items.get(items.size()-1);
    }

    public int getSize() {
        return items.size();
    }



}
