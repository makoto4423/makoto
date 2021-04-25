package problem800To900;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class a897increasingBST {

    List<Integer> list;

    public TreeNode increasingBST(TreeNode root) {
        list = new ArrayList<>();
        recur(root);
        return getTree(0);
    }

    public void recur(TreeNode node) {
        if (node.left != null) {
            recur(node.left);
        }
        list.add(node.val);
        if (node.right != null) {
            recur(node.right);
        }
    }

    public TreeNode getTree(int i) {
        if (i == list.size()) {
            return null;
        }
        TreeNode child = getTree(i + 1);
        TreeNode p = new TreeNode(list.get(i));
        p.right = child;
        return p;
    }
}
