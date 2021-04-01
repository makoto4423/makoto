package problem1To100;

import struct.ListNode;

import java.util.ArrayList;
import java.util.List;

public class a61rotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) return head;
        List<ListNode> queue = new ArrayList<>();
        while (head != null) {
            queue.add(head);
            head = head.next;
        }
        int len = queue.size();
        k = k % len;
        if(k == 0 || len == 1) return queue.get(0);
        queue.get(len - k - 1).next = null;
        queue.get(len - 1).next = queue.get(0);
        return queue.get(len - k);
    }
}
