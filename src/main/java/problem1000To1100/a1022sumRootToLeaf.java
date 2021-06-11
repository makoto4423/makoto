package problem1000To1100;

import struct.TreeNode;

public class a1022sumRootToLeaf {
    public int sumRootToLeaf(TreeNode root) {
        int res = 0;
        if (root == null) return res;
        if (root.left != null || root.right != null) {
            int r = root.val << 1;
            if (root.left != null) {
                root.left.val = (r ^ root.left.val);
                res += sumRootToLeaf(root.left);
            }
            if (root.right != null) {
                root.right.val = (r ^ root.right.val);
                res += sumRootToLeaf(root.right);
            }
            return res;
        }
        return root.val;
    }
}
