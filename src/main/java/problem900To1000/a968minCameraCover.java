package problem900To1000;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 0 : 未监控 ; 1 : 已监控 ; 2 ：摄像头
public class a968minCameraCover {
    List<List<TreeNode>> nodes;

    public int minCameraCover(TreeNode root) {
        nodes = new ArrayList<>();
        if (root == null) return 0;
        List<TreeNode> parent = new ArrayList<>();
        parent.add(root);
        recur(parent);
        if (nodes.size() == 1) return 1;
        int sum = 0;
        for (int i = nodes.size() - 2; i >= 1; i--) {
            List<TreeNode> node = nodes.get(i);
            for (TreeNode n : node) {
                if (n.left != null || n.right != null) {
                    int left = 1, right = 1;
                    if (n.left != null) {
                        left = n.left.val;
                    }
                    if (n.right != null) {
                        right = n.right.val;
                    }
                    if (left == 0 || right == 0) {
                        n.val = 2;
                        sum++;
                    } else if (left == 2 || right == 2) {
                        n.val = 1;
                    }
                }
            }
        }
        if (root.left != null && root.right != null) {
            if (root.left.val != 2 && root.right.val != 2) {
                sum++;
            } else if (root.left.val == 0 || root.right.val == 0) {
                sum++;
            }
        } else if (root.left != null) {
            if (root.left.val != 2) {
                sum++;
            }
        } else if (root.right != null) {
            if (root.right.val != 2) {
                sum++;
            }
        }
        return sum;
    }

    public void recur(List<TreeNode> parent) {
        if (parent.size() != 0) {
            nodes.add(parent);
        }
        List<TreeNode> child = new ArrayList<>();
        for (TreeNode n : parent) {
            if (n.left != null) {
                child.add(n.left);
            }
            if (n.right != null) {
                child.add(n.right);
            }
        }
        parent = child;
        if (parent.size() != 0) {
            recur(parent);
        }
    }
}
