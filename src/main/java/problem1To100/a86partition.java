package problem1To100;

import struct.ListNode;

public class a86partition {
    public ListNode partition(ListNode head, int x) {
        ListNode big = new ListNode(-1);
        ListNode preBig = new ListNode(-1);
        preBig.next = big;
        ListNode small = new ListNode(-1);
        ListNode preSma = new ListNode(-1);
        preSma.next = small;
        while (head != null) {
            if (head.val >= x) {
                big.next = head;
                big = big.next;
            } else {
                small.next = head;
                small = small.next;
            }
            head = head.next;
        }
        big.next = null;
        small.next = preBig.next.next;
        return preSma.next.next;
    }
}
