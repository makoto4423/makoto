package problem100To200;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class a111minDepth {
    int depth=1;
    public int minDepth(TreeNode root) {
        if(root == null)    return 0;
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        recur(list);
        return depth;
    }

    public void recur(List<TreeNode> nodes){
         List<TreeNode> child = new ArrayList<>();
         for(TreeNode node : nodes){
             if(node.left == null && node.right == null)    return;
             if(node.left != null)  child.add(node.left);
             if(node.right != null) child.add(node.right);
         }
         depth++;
         recur(child);
    }

}
