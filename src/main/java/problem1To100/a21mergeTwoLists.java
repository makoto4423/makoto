package problem1To100;

import struct.ListNode;

public class a21mergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode pos = ans;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                pos.next = l1;
                l1 = l1.next;
            }else{
                pos.next = l2;
                l2 = l2.next;
            }
            pos = pos.next;
        }
        if(l1 != null){
            pos.next = l1;
        }
        if(l2 != null){
            pos.next = l2;
        }
        return ans.next;
    }
}
