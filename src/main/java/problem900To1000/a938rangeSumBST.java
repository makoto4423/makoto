package problem900To1000;

import struct.TreeNode;

public class a938rangeSumBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int res = 0;
        if (root == null) return res;
        if (low > root.val) {
            res += rangeSumBST(root.right, low, high);
        } else if (high < root.val) {
            res += rangeSumBST(root.left, low, high);
        } else {
            res += root.val + rangeSumBST(root.left, low, high)
                    + rangeSumBST(root.right, low, high);
        }
        return res;
    }
}
