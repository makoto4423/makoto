package problem1To100;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class a94inorderTraversal {
    List<Integer> res;

    public List<Integer> inorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        if(root == null)    return res;
        recur(root);
        return res;
    }

    public void recur(TreeNode node) {
        if (node.left != null) {
            recur(node.left);
        }
        res.add(node.val);
        if (node.right != null) {
            recur(node.right);
        }
    }
}
