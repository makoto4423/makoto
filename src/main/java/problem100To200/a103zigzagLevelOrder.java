package problem100To200;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class a103zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)    return new ArrayList<>();
        int i=0;
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> node = new ArrayList<>();
        node.add(root);
        while(node.size() != 0){
            List<Integer> list = new ArrayList<>();
            List<TreeNode> child = new ArrayList<>();
            if(i == 1){
                Collections.reverse(node);
            }
            for(TreeNode n : node){
                list.add(n.val);
            }
            res.add(list);
            if(i == 1){
                Collections.reverse(node);
            }
            for(TreeNode n : node){
                if(n.left != null)  child.add(n.left);
                if(n.right != null) child.add(n.right);
            }
            i ^= 1;
            node = child;
        }
        return res;
    }
}
