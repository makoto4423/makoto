package problem200To300;

import struct.ListNode;
import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class a226invertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)    return null;
        List<TreeNode> node = new ArrayList<>();
        node.add(root);
        help(node);
        return root;
    }

    public void help(List<TreeNode> node){
        if(node.size() == 0)    return;
        List<TreeNode> child = new ArrayList<>();
        for(TreeNode n : node){
            TreeNode left = n.left;
            n.left = n.right;
            n.right = left;
            if(n.left != null)  child.add(n.left);
            if(n.right != null) child.add(n.right);
        }
        help(child);
    }

}
