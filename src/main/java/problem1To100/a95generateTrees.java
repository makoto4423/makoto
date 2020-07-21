package problem1To100;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

@Deprecated
public class a95generateTrees {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return dp(1, n);
    }

    public List<TreeNode> dp(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }

        for(int i=start; i<=end; i++){
            List<TreeNode> left = dp(start,i-1);
            List<TreeNode> right = dp(i+1,end);
            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    res.add(node);
                }
            }
        }
        return res;
    }
}
