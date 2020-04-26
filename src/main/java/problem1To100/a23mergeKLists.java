package problem1To100;

import struct.ListNode;

import java.util.*;

//一看到困难瞬间想放弃，不行啊，分治也想过，还是选择最粗暴的蛮力，但卡在指针的移动上
@Deprecated
public class a23mergeKLists {
//    // 用优先队列解决
//    public ListNode mergeKLists1(ListNode[] lists) {
//        if(lists == null || lists.length == 0)  return null;
//        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));
//        for(ListNode node : lists){
//            if(node != null)    queue.add(node);
//        }
//        ListNode ans = new ListNode(0);
//        ListNode p = ans;
//        while (!queue.isEmpty()){
//            p.next = queue.poll();
//            p = p.next;
//            if(p.next != null)  queue.add(p.next);
//        }
//        return ans.next;
//    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)  return null;
        return merge(lists, 0, lists.length-1);
    }

    public ListNode merge(ListNode[] lists, int begin, int end){
        if(begin == end) return lists[begin];
        int mid = begin + (end-begin)/2;
        ListNode l1 = merge(lists, begin, mid);
        ListNode l2 = merge(lists, mid+1, end);
        return divide(l1,l2);
    }

    public ListNode divide(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val > l2.val){
            l2.next = divide(l1,l2.next);
            return l2;
        }else{
            l1.next = divide(l1.next, l2);
            return l1;
        }
    }


//    public ListNode mergeKLists(ListNode[] lists) {
//        List<ListNode> nodes = new ArrayList<>(Arrays.asList(lists));
//        int len = lists.length;
//        int remove = 0;
//        ListNode result = new ListNode(Integer.MAX_VALUE);
//        Iterator<ListNode> iterator = nodes.iterator();
//        while(remove != len){
//            ListNode min = new ListNode(Integer.MAX_VALUE);
//            while(iterator.hasNext()){
//                ListNode node = iterator.next();
//                if(node == null){
//                    iterator.remove();
//                    remove++;
//                    continue;
//                }
//                if(min.val > node.val){
//                    min = node;
//                }
//            }
//            result.next = min;
//            min = min.next;
//            iterator = nodes.iterator();
//        }
//        return result.next;
//    }

}
