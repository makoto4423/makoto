package problem500To600;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class a530getMinimumDifference {
    List<Integer> list = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        int res = Integer.MAX_VALUE;
        dp(root);
        for(int i=0;i<list.size()-1;i++){
            res = Math.min(res, list.get(i+1)-list.get(i));
        }
        return res;
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
