package problem100To200;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class a173BSTIterator {

    List<Integer> list;
    int index;

    public a173BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        index = 0;
        init(root);
    }

    private void init(TreeNode node) {
        if (node.left != null) {
            init(node.left);
        }
        list.add(node.val);
        if (node.right != null) {
            init(node.right);
        }
    }

    public int next() {
        return list.get(index++);
    }

    public boolean hasNext() {
        return index != list.size();
    }
}
