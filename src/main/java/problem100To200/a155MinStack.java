package problem100To200;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class a155MinStack {

    private PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt((o)->{
        return o;
    }));
    private Stack<Integer> stack = new Stack<>();
    /** initialize your data structure here. */
    public a155MinStack() {

    }

    public void push(int x) {
        queue.add(x);
        stack.add(x);
    }

    public void pop() {
        int x = stack.pop();
        queue.remove(x);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return queue.peek();
    }
}
