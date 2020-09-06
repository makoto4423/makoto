package problem100To200;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class a107levelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null)    return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> node = new ArrayList<>();
        node.add(root);
        while (node.size() != 0){
            List<TreeNode> child = new ArrayList<>();
            List<Integer> mid = new ArrayList<>();
            for(TreeNode n : node){
                mid.add(n.val);
                if(n.left != null) child.add(n.left);
                if(n.right != null) child.add(n.right);
            }
            res.add(mid);
            node = child;
        }
        Collections.reverse(res);
        return res;
    }
}
