package interview1To100;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class a32_1levelOrder {
    List<Integer> recur = new ArrayList<>();
    public int[] levelOrder(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        if(root != null){
            nodes.add(root);
        }
        helper(nodes);
        int[] res = new int[recur.size()];
        for(int i=0; i<recur.size(); i++){
            res[i] = recur.get(i);
        }
        return res;
    }

    public void helper(List<TreeNode> nodes){
        if(nodes.size() == 0){
            return;
        }
        List<TreeNode> child = new ArrayList<>();
        for(TreeNode node :nodes){
            recur.add(node.val);
            if(node.left != null){
                child.add(node.left);
            }
            if(node.right != null){
                child.add(node.right);
            }
        }
        helper(child);

    }
}
