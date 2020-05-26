package problem200To300;

import struct.ListNode;

import java.util.ArrayList;
import java.util.List;

public class a234isPalindrome {
    public boolean isPalindrome(ListNode head) {
        if(head == null)    return true;
        List<Integer> list = new ArrayList<>();
        list.add(head.val);
        while (head.next != null){
            list.add(head.next.val);
            head = head.next;
        }
        for(int i=0;i<list.size()/2;i++){
            if(!list.get(i).equals(list.get(list.size() - i - 1))){
                return false;
            }
        }
        return true;
    }
}
