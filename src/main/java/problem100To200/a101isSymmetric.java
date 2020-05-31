package problem100To200;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 层次遍历写多，脑子都有惯性了，然而这是效率最低的
public class a101isSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if(root == null || (root.left ==null && root.right==null))    return true;
        List<TreeNode> node = new ArrayList<>();
        node.add(root);
        return help(node);
    }

    public boolean help(List<TreeNode> node){
        if(node.size() == 0) return true;
        List<TreeNode> child = new ArrayList<>();
        for(int i=0,j=node.size()-1;i<j;i++,j--){
            if(node.get(i) == null && node.get(j) == null)  continue;
            if(node.get(i) == null || node.get(j) == null)  return false;
            if(node.get(i).val != node.get(j).val)  return false;
        }
        for(TreeNode n : node){
            if(n == null) continue;
            child.add(n.left);
            child.add(n.right);
        }
        return help(child);
    }

}
