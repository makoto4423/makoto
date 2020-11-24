package problem200To300;

import struct.TreeNode;

public class a222countNodes {

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        TreeNode node = root;
        int level = 0;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        int low = 1 << (level), high = (1 << (level + 1)) - 1;
        while (low < high) {
            int mid = low + (high - low +1) / 2;
            if (exists(root, level, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean exists(TreeNode root, int level, int k) {
        TreeNode node = root;
        int bit = 1 << (level - 1);
        while (node != null && bit > 0) {
            if ((bit & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bit = bit >> 1;
        }
        return node != null;
    }
//    public int countNodes(TreeNode root) {
//        if (root == null) return 0;
//        return 1 + countNodes(root.left) + countNodes(root.right);
//    }
}
