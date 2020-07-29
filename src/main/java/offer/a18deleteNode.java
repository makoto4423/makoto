package offer;

import struct.ListNode;

public class a18deleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val == val) return head.next;
        ListNode node = new ListNode(0);
        node.next = head;
        while (head.next != null){
            if(head.next.val == val){
                if(head.next.next == null){
                    head.next = null;
                }else{
                    head.next = head.next.next;
                }
                break;
            }else{
                head = head.next;
            }
        }
        return node.next;
    }
}
