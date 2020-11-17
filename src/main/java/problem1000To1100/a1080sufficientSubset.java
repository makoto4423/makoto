package problem1000To1100;

import struct.TreeNode;

public class a1080sufficientSubset {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root == null) return null;
        TreeNode temp = copy(root);
        add(root);
        return recur(root, temp, limit);
    }

    public TreeNode copy(TreeNode node) {
        TreeNode t = new TreeNode(node.val);
        if (node.left != null) {
            t.left = copy(node.left);
        }
        if (node.right != null) {
            t.right = copy(node.right);
        }
        return t;
    }

    public void add(TreeNode node) {
        if (node.left == null && node.right == null) {
            return;
        }
        if (node.left != null) {
            node.left.val += node.val;
            add(node.left);
        }
        if (node.right != null) {
            node.right.val += node.val;
            add(node.right);
        }
    }

    public TreeNode recur(TreeNode node, TreeNode temp, int limit) {
        if (temp.left == null && temp.right == null) {
            if (node.val < limit) {
                return null;
            }
        } else {
            if (temp.left != null) {
                temp.left = recur(node.left, temp.left, limit);
            }
            if (temp.right != null) {
                temp.right = recur(node.right, temp.right, limit);
            }
            if (temp.left == null && temp.right == null) {
                return null;
            }
        }
        return temp;
    }
}
