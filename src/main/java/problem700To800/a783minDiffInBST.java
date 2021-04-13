package problem700To800;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class a783minDiffInBST {
    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        help(root, list);
        Collections.sort(list);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            min = Math.min(list.get(i + 1) - list.get(i), min);
        }
        return min;
    }

    public void help(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (root.left != null) help(root.left, list);
        list.add(root.val);
        if (root.right != null) help(root.right, list);
    }
}
