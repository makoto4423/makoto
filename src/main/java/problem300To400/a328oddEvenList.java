package problem300To400;

import struct.ListNode;

public class a328oddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = new ListNode(head.val);
        ListNode preOdd = new ListNode(-1);
        preOdd.next = odd;
        head = head.next;
        ListNode even = new ListNode(head.val);
        ListNode preEven = new ListNode(-1);
        preEven.next = even;
        head = head.next;
        while (head != null){
            odd.next = new ListNode(head.val);
            odd = odd.next;
            head = head.next;
            if(head != null){
                even.next = new ListNode(head.val);
                even = even.next;
                head = head.next;
            }
        }
        odd.next = preEven.next;
        return preOdd.next;
    }
}
