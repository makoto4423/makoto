package problem100To200;

import circular.A;
import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class a113pathSum {
    List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        if(root == null)    return res;
        List<Integer> list = new ArrayList<>();
        recur(root, list, sum);
        return res;
    }

    public void recur(TreeNode node, List<Integer> list, int sum) {
        list.add(node.val);
        sum -= node.val;
        if (node.left == null && node.right == null) {
            if (sum == 0) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        if (node.left != null) {
            recur(node.left, list, sum);
            list.remove(list.size() - 1);
        }
        if (node.right != null) {
            recur(node.right, list, sum);
            list.remove(list.size() - 1);
        }

    }
}
