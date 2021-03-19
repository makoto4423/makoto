package problem1To100;

import struct.ListNode;

import java.util.Stack;

public class a92reverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        ListNode first = new ListNode(-1);
        first.next = head;
        Stack<ListNode> stack = new Stack<>();
        int num = 1;
        while (left != 1 && num != left - 1) {
            head = head.next;
            num++;
        }
        ListNode node = head;
        if (left == 1) {
            node = first;
            num--;
        } else {
            head = head.next;
        }
        while (num != right) {
            stack.push(head);
            head = head.next;
            num++;
        }
        while (!stack.isEmpty()) {
            node.next = stack.pop();
            node = node.next;
        }
        if (node != null) {
            node.next = head;
        }
        return first.next;
    }
}
