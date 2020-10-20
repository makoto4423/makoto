package problem100To200;

import struct.ListNode;

import java.util.ArrayList;
import java.util.List;

public class a143reorderList {
    public void reorderList(ListNode head) {
        if(head == null) return;
        ListNode node = new ListNode(1);
        node.next = head;
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        head = node.next;
        for (int i = list.size() - 1; i >= (list.size()+1) / 2; i--) {
            ListNode next = head.next;
            head.next = list.get(i);
            head = head.next;
            head.next = next;
            if (next != null) {
                head = head.next;
            }
        }
        head.next = null;
    }
}
