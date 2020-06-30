package offer;

import java.util.Stack;

// 用java写这题就是开挂，stack本身就提供了api支持队列
public class a09CQueue {
    Stack<Integer> stack = new Stack<>();
    public a09CQueue() {

    }

    public void appendTail(int value) {
        stack.push(value);
    }

    public int deleteHead() {
        if(stack.size() == 0){
            return -1;
        }
        Integer i = stack.get(0);
        stack.removeElementAt(0);
        return i;
    }
}
