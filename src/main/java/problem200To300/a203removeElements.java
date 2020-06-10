package problem200To300;

import struct.ListNode;

public class a203removeElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode pre = node;
        while (head != null){
            if(head.val == val){
                pre.next = head.next;
            }else {
                pre = head;
            }
            head = head.next;
        }
        return node.next;
    }
}
