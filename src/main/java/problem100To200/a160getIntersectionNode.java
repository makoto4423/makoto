package problem100To200;

import struct.ListNode;

import java.util.Stack;

public class a160getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pre = null;
        Stack<ListNode> aStack = new Stack<>();
        Stack<ListNode> bStack = new Stack<>();
        while (headA != null) {
            aStack.push(headA);
            headA = headA.next;
        }
        while (headB != null) {
            bStack.push(headB);
            headB = headB.next;
        }
        while (!aStack.isEmpty() && !bStack.isEmpty()) {
            ListNode a = aStack.pop();
            ListNode b = bStack.pop();
            if (a == b) {
                pre = a;
            }
        }
        return pre;
    }
}
