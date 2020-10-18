package problem1To100;

import struct.ListNode;

import java.util.ArrayList;
import java.util.List;

public class a19removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        while (head != null){
            list.add(head);
            head = head.next;
        }
        list.add(null);
        if(n == list.size()-1){
            if(n == 1){
                return null;
            }else{
                return list.get(1);
            }
        }
        list.get(list.size()-n-2).next = list.get(list.size()-n);
        return list.get(0);
    }
}
