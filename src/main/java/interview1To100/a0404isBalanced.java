package interview1To100;

import struct.TreeNode;

public class a0404isBalanced {
    boolean tag = true;
    public boolean isBalanced(TreeNode root) {
        recur(root);
        return tag;
    }

    public int recur(TreeNode node){
        if(!tag)    return -1;
        if(node == null){
            return 0;
        }
        int left = recur(node.left);
        int right = recur(node.right);
        if(Math.abs(left-right) > 1){
            tag = false;
            return -1;
        }
        return Math.max(left,right)+1;
    }
}
