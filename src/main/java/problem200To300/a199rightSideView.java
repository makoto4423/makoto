package problem200To300;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 层次遍历
public class a199rightSideView {
    List<Integer> ans;
    public List<Integer> rightSideView(TreeNode root) {
        ans = new ArrayList<>();
        if(root == null)    return ans;
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        help(nodes);
        return ans;
    }

    public void help(List<TreeNode> nodes){
        if(nodes.size() == 0)   return;
        ans.add(nodes.get(nodes.size()-1).val);
        List<TreeNode> childNodes = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node.left != null) {
                childNodes.add(node.left);
            }
            if (node.right != null) {
                childNodes.add(node.right);
            }
        }
        help(childNodes);
    }
}
