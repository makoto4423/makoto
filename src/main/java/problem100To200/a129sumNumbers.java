package problem100To200;

import struct.TreeNode;

public class a129sumNumbers {

    int res;

    public int sumNumbers(TreeNode root) {
        res = 0;
        if (root == null) return res;
        recur(root);
        return res;
    }

    public void recur(TreeNode node) {
        if (node.left == null && node.right == null) {
            res += node.val;
            return;
        }
        if (node.left != null) {
            node.left.val += node.val * 10;
            recur(node.left);
        }
        if (node.right != null) {
            node.right.val += node.val * 10;
            recur(node.right);
        }
    }
}
