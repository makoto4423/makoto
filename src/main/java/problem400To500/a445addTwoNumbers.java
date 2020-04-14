package problem400To500;

import struct.ListNode;

import java.util.Stack;

public class a445addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        while(l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        Stack<Integer> stack2 = new Stack<>();
        while (l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int up = 0;
        Stack<Integer> stack3 = new Stack<>();
        while(stack1.size() != 0 || stack2.size() != 0){
            Integer i1 = stack1.size() == 0 ? 0 : stack1.pop();
            Integer i2 = stack2.size() == 0 ? 0 : stack2.pop();
            if(i1+i2+up>9){
                stack3.push(i1+i2+up-10);
                up = 1;
            }else{
                stack3.push(i1+i2+up);
                up = 0;
            }
        }
        if(up != 0) stack3.push(up);
        if(stack3.size() == 0)  return new ListNode(0);
        ListNode node = new ListNode(stack3.pop());
        ListNode result = node;
        while(stack3.size() != 0){
            node.next = new ListNode(stack3.pop());
            node = node.next;
        }
        return result;
    }
}
