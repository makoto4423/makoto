package problem1To100;

import struct.ListNode;

import java.util.ArrayDeque;

public class a25reverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ArrayDeque<ListNode> dequeue = new ArrayDeque<>();
        ListNode pre = new ListNode(0);
        pre.next = head;
        while(head.next!=null){
            dequeue.add(head);
            if(dequeue.size() == k){
                ListNode next = head.next;
                dequeue.pollLast();
                while(dequeue.size() != 0){
                    head.next = dequeue.pollLast();
                    head = head.next;
                }
                head.next = next;
            }
            head = head.next;
        }
        while(dequeue.size() != 0){
            head.next = dequeue.pollFirst();
        }
        return pre.next;
    }
}
