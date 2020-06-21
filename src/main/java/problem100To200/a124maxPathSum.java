package problem100To200;

import struct.TreeNode;

@Deprecated
// 一看到hard脑子都懒得动了，看了下答案，这不是很简单嘛。。。。
public class a124maxPathSum {
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        recur(root);
        return res;
    }

    public int recur(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = Math.max(recur(node.left),0);
        int right = Math.max(recur(node.right),0);

        int val = left+node.val+right;
        res = Math.max(res,val);
        return node.val+ Math.max(left,right);
    }
}
