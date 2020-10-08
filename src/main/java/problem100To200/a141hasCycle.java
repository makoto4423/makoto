package problem100To200;

import struct.ListNode;

public class a141hasCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null)    return false;
        ListNode next = head.next;
        while (head != null && next != null){
            if(head == next)    return true;
            head = head.next;
            next = next.next;
            if(next != null){
                next = next.next;
            }
        }
        return false;
    }
}
