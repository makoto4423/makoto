package problem100To200;

import struct.ListNode;
import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class a103sortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        if(list.size() == 0)    return null;
        return recur(list,0,list.size()-1);
    }

    public TreeNode recur(List<Integer> list, int left, int right){
        if(right-left == 1){
            TreeNode node = new TreeNode(list.get(right));
            node.left = new TreeNode(list.get(left));
            return node;
        }else if(right == left){
            return new TreeNode(list.get(left));
        }
        int mid = left + (right-left)/2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = recur(list,left,mid-1);
        node.right = recur(list, mid+1, right);
        return node;
    }
}
