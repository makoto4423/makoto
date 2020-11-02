package problem1500To1600;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 官方解法究竟写的是啥。。完全看不懂，其他人写的倒是看懂了
@Deprecated
public class a1530countPairs {
    int res;

    public int countPairs(TreeNode root, int distance) {
        res = 0;
        dfs(root, distance);
        return res;
    }

    public List<Integer> dfs(TreeNode node, int distance) {
        List<Integer> list = new ArrayList<>();
        if (node == null) return list;
        if (node.left == null && node.right == null) {
            list.add(0);
            return list;
        }
        List<Integer> left = dfs(node.left, distance);
        for (int i : left) {
            if (++i > distance) {
                continue;
            }
            list.add(i);
        }
        List<Integer> right = dfs(node.right, distance);
        for (int i : right) {
            if (++i > distance) {
                continue;
            }
            list.add(i);
        }
        for (int i : left) {
            for (int j : right) {
                if (i + j + 2 <= distance) res++;
            }
        }
        return list;
    }
}
