package problem800To900;

import struct.TreeNode;

// what is up?今天的代码就没跑过三次以上，这题甚至测都没测过仍上去就成功了
public class a814pruneTree {
    public TreeNode pruneTree(TreeNode root) {
        if(dp(root)){
            return null;
        }
        return root;
    }

    public boolean dp(TreeNode node){
        if(node.left == null && node.right == null && node.val == 0){
            return true;
        }
        if(node.left != null && dp(node.left)){
            node.left = null;
        }
        if(node.right != null && dp(node.right)){
            node.right = null;
        }
        return node.left == null && node.right == null && node.val == 0;
    }
}
