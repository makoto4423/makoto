package problem900To1000;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class a993isCousins {

    List<List<Integer>> list;

    public boolean isCousins(TreeNode root, int x, int y) {
        list = new ArrayList<>();
        recur(Collections.singletonList(root));
        for (List<Integer> child : list) {
            int a = child.indexOf(x);
            int b = child.indexOf(y);
            if (a == -1 && b == -1) {
                continue;
            }
            if (a != -1 && b != -1) {
                return a / 2 != b / 2;
            } else {
                return false;
            }
        }
        return false;
    }

    public void recur(List<TreeNode> nodes) {
        List<Integer> val = new ArrayList<>();
        List<TreeNode> child = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node == null) {
                val.add(null);
            } else {
                val.add(node.val);
            }
            if (node != null && (node.left != null || node.right != null)) {
                child.add(node.left);
                child.add(node.right);
            }
        }
        list.add(val);
        if (!child.isEmpty()) {
            recur(child);
        }
    }

}
