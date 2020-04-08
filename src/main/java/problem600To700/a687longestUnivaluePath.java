package problem600To700;

import struct.TreeNode;

// 看了答案也看不懂，绝望
@Deprecated
public class a687longestUnivaluePath {
    public int longestUnivaluePath(TreeNode root) {
        return helper(root,0,0);
    }

    public int helper(TreeNode root,  int cnt, int max){
        if(root == null)
            return 0;
        boolean repeat = false;
        if(cnt != 0){
            repeat = true;
        }
        if(root.left != null){
            if(root.left.val == root.val){
                cnt++;
                max = Math.max(cnt,max);
            }else{
                cnt = 0;
            }
            max = helper(root.left, cnt, max);
            if(repeat){
                cnt = 0;
            }
        }
        if(root.right != null){
            if(root.right.val == root.val){
                cnt++;
                max = Math.max(cnt,max);
            }else {
                cnt = 0;
            }
            max = helper(root.right, cnt, max);
        }
        return max;
    }
}
