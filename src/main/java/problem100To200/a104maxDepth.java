package problem100To200;

import struct.TreeNode;

public class a104maxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null)    return 0;
        return recur(root, 1);
    }

    public int recur(TreeNode node, int dep){
        if(node.left == null && node.right == null){
            return dep;
        }
        int left=0,right=0;
        if(node.left != null){
            left = recur(node.left, dep+1);
        }
        if(node.right != null){
            right = recur(node.right, dep+1);
        }
        return Math.max(left,right);
    }
}
