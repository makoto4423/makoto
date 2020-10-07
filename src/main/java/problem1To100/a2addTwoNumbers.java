package problem1To100;

import struct.ListNode;

public class a2addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        int pre = 0;
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int v = a + b + pre;
            if (v > 9) {
                pre = 1;
                v -= 10;
            } else {
                pre = 0;
            }
            node.next = new ListNode(v);
            node = node.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (pre == 1) {
            node.next = new ListNode(1);
        }
        return head.next;
    }
}
