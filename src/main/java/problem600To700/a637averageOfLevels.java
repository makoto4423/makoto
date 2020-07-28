package problem600To700;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class a637averageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null)    return new ArrayList<>();
        List<TreeNode> node = new ArrayList<>();
        node.add(root);
        return recur(node, new ArrayList<>());
    }

    public List<Double> recur(List<TreeNode> node, List<Double> res){
        long l = 0;
        if(node.size() == 0)    return res;
        List<TreeNode> child = new ArrayList<>();
        for(TreeNode n : node){
            l += n.val;
            if(n.left != null) child.add(n.left);
            if(n.right != null) child.add(n.right);
        }
        res.add((double) l/node.size());
        return recur(child, res);
    }
}
