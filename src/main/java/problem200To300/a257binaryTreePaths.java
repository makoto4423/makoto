package problem200To300;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class a257binaryTreePaths {
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null)    return res;
        help(root,root.val+"->");
        return res;
    }

    public void help(TreeNode node,String s){
        if(node.left == null && node.right == null){
            s = s.substring(0,s.length()-2);
            res.add(s);
            return;
        }
        if(node.left != null){
            help(node.left,s+node.left.val+"->");
        }
        if(node.right != null){
            help(node.right,s+node.right.val+"->");
        }
    }
}
