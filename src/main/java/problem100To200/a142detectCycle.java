package problem100To200;

import struct.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode-solution/
 *
 * b的定义为slow 指针进入环后，又走了 b 的距离与fast 相遇，而不是环的进入点与相遇点的距离
 * 所以 n 的定义为 当slow尚未走完A环（此环和实际的环不是同一个东西）就在某个点与fast指针相遇
 * 而此时fast指针围绕环移动了n圈
 * A环实际上是，当slow指针没有和fast指针相遇，就在概念上将实际的环扩大，直到指针相遇
 * 此时对于A环，slow指针尚未走完A环的距离，而fast指针必定走完一圈以上
 */
public class a142detectCycle {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if(set.contains(head)){
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }
}
