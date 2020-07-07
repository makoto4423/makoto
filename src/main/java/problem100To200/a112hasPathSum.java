package problem100To200;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class a112hasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)    return false;
        return help(root, root.val, sum);
    }

    public boolean help(TreeNode node, int amount, int sum){
        if(node.left == null && node.right == null){
            return amount == sum;
        }
        if(node.left != null){
            boolean left = help(node.left,amount+node.left.val, sum);
             if(left)    return true;
        }
        if(node.right != null){
            return help(node.right,amount+node.right.val, sum);
        }
        return false;
    }
}
