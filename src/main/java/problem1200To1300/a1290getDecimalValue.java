package problem1200To1300;

import struct.ListNode;

public class a1290getDecimalValue {
    public int getDecimalValue(ListNode head) {
        if(head == null)    return 0;
        int val=head.val;
        while(head.next != null){
            head = head.next;
            val = val*2+head.val;
        }
        return val;
    }
}
