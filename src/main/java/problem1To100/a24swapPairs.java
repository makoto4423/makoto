package problem1To100;

import struct.ListNode;

public class a24swapPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null)    return null;
        ListNode next = head.next;
        if(next == null){
            return head;
        }
        ListNode nextNext = next.next;
        next.next = head;
        head.next = nextNext;
        if(head.next != null){
            head.next = swapPairs(head.next);
        }
        return next;
    }
}
