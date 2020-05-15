package problem200To300;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class a230kthSmallest {
    List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        dp(root);
        return list.get(k-1);
    }

    public void dp(TreeNode root){
        if(root.left != null){
            dp(root.left);
        }
        list.add(root.val);
        if(root.right != null){
            dp(root.right);
        }
    }
}
