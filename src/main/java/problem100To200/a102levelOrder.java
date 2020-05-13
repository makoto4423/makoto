package problem100To200;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class a102levelOrder {
    List<List<Integer>> res;
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)    return new ArrayList<>();
        res = new ArrayList<>();
        List<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(root);
        recur(treeNodes);
        return res;
    }

    public void recur(List<TreeNode> node){
        if(node.size() == 0){
            return;
        }
        List<Integer> list = new ArrayList<>();
        List<TreeNode> child = new ArrayList<>();
        for(TreeNode treeNode: node){
            list.add(treeNode.val);
            if(treeNode.left != null)   child.add(treeNode.left);
            if(treeNode.right != null)  child.add(treeNode.right);
        }
        res.add(list);
        recur(child);
    }
}
