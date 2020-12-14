package problem1000To1100;

import struct.TreeNode;

import java.util.Arrays;

public class a1008bstFromPreorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        int len = preorder.length;
        int[] sort = new int[len];
        System.arraycopy(preorder, 0, sort, 0, len);
        Arrays.sort(sort);
        return recur(preorder, sort, 0, len - 1, 0);
    }

    public TreeNode recur(int[] pre, int[] sort, int left, int right, int root) {
        if (left == right) return new TreeNode(sort[left]);
        TreeNode node = new TreeNode(pre[root]);
        int i = left;
        for (; i < right; i++) {
            if (sort[i] == pre[root]) break;
        }
        if (i - 1 >= left) {
            node.left = recur(pre, sort, left, i - 1, root + 1);
        }
        if (right >= i + 1) {
            node.right = recur(pre, sort, i + 1, right, root+i-left+1);
        }
        return node;
    }
}
