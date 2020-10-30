package interview1To100;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class a0406inorderSuccessor {

    List<TreeNode> list;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        list = new ArrayList<>();
        if (root == null || p == null) return null;
        recur(root);
        int i = 0;
        for (; i < list.size(); i++) {
            if (list.get(i) == p) break;
        }
        if (i == list.size() - 1 || i == list.size()) return null;
        return list.get(i + 1);
    }

    public void recur(TreeNode node) {
        if (node.left != null) {
            recur(node.left);
        }
        list.add(node);
        if (node.right != null) {
            recur(node.right);
        }
    }
}
