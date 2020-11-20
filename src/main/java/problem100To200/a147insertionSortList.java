package problem100To200;

import struct.ListNode;

import java.util.ArrayList;
import java.util.List;

// 不想考虑指针的问题，装成list再模拟插入，再把list转成listnode
public class a147insertionSortList {
    public ListNode insertionSortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            if (list.size() == 0) {
                list.add(head.val);
            } else {
                int i = 0;
                for (; i < list.size(); i++) {
                    if (list.get(i) >= head.val) break;
                }
                list.add(i, head.val);
            }
            head = head.next;
        }
        ListNode pre = new ListNode(-1);
        ListNode h = new ListNode(-1);
        pre.next = h;
        for (int i : list) {
            h.next = new ListNode(i);
            h = h.next;
        }
        return pre.next.next;
    }
}
