package problem200To300;

import struct.TreeNode;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// 没留意到搜索树，还想着这简单难度的怎么还要想个十来分钟。。。
public class a235lowestCommonAncestor {
    TreeNode parent;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recur(root, p, q);
        return parent;
    }

    public Set<TreeNode> recur(TreeNode node, TreeNode p, TreeNode q) {
        Set<TreeNode> set = new HashSet<>();
        if (node.left != null) {
            set.addAll(recur(node.left, p, q));
        }
        if (node.right != null) {
            set.addAll(recur(node.right, p, q));
        }
        set.add(node);
        if (set.contains(p) && set.contains(q)) {
            parent = node;
            return Collections.emptySet();
        }
        return set;
    }
}
