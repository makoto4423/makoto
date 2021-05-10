package problem800To900;

import struct.TreeNode;

import java.util.LinkedList;

public class a872leafSimilar {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        LinkedList<TreeNode> q1 = new LinkedList<>();
        q1.offer(root1);
        LinkedList<TreeNode> q2 = new LinkedList<>();
        q2.offer(root2);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            int a = getLeft(q1);
            int b = getLeft(q2);
            if (a != b) return false;
        }
        return q1.isEmpty() && q2.isEmpty();
    }

    public int getLeft(LinkedList<TreeNode> list) {
        int a = -1;
        while (!list.isEmpty()) {
            TreeNode n = list.poll();
            if (n.left == null && n.right == null) {
                return n.val;
            }
            if (n.right != null) {
                list.add(0, n.right);
            }
            if (n.left != null) {
                list.add(0, n.left);
            }
        }
        return a;
    }
}
