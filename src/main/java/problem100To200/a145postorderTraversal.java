package problem100To200;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
// Morris 遍历
public class a145postorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)    return res;
        Stack<TreeNode> stack = new Stack<>();
        while (root.left != null || root.right != null || !stack.isEmpty()) {
            if (root.left != null) {
                TreeNode node = root.left;
                root.left = null;
                stack.add(root);
                root = node;
            } else if (root.right != null) {
                TreeNode node = root.right;
                root.right = null;
                stack.add(root);
                root = node;
            } else {
                res.add(root.val);
                root = stack.pop();
            }
        }
        res.add(root.val);
        return res;
    }
}
