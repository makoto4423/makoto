package problem1To100;

import struct.ListNode;

import java.util.HashSet;
import java.util.Set;

// 排序链表，搞得这么费劲干啥。。。。
public class a82deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        Set<Integer> set = new HashSet<>();
        Set<Integer> dup = new HashSet<>();
        ListNode pre = new ListNode(1);
        pre.next = head;
        while (head != null){
            if(set.contains(head.val)){
                dup.add(head.val);
            }
            set.add(head.val);
            head = head.next;
        }
        head = pre.next;
        ListNode node = new ListNode(1);
        node.next = pre;
        pre.next = null;
        while (head != null){
            if(!dup.contains(head.val)){
                pre.next = new ListNode(head.val);
                pre = pre.next;
            }
            head = head.next;
        }
        return node.next.next;
    }
}
