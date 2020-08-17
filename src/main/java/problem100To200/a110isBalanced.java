package problem100To200;

import struct.TreeNode;

public class a110isBalanced {
    boolean tag = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null)    return true;
        recur(root);
        return tag;
    }

    public int recur(TreeNode node){
        if(!tag){
            return -1;
        }
        if(node.left == null && node.right == null){
            return 0;
        }
        int left = 0,right=0;
        if(node.left != null){
            left = recur(node.left)+1;
        }
        if(node.right != null){
            right = recur(node.right)+1;
        }
        if(Math.abs(left-right)>1){
            tag = false;
        }
        return Math.max(left,right);
    }
}
