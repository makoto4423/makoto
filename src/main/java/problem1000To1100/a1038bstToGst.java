package problem1000To1100;

import struct.TreeNode;

public class a1038bstToGst {
    int pre = 0;

    public TreeNode bstToGst(TreeNode root) {
        if(root == null)    return null;
        if (root.right != null) {
            bstToGst(root.right);
        }
        root.val = root.val + pre;
        pre = root.val;
        if (root.left != null) {
            bstToGst(root.left);
        }
        return root;
    }
}
