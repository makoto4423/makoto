package problem500To600;

import struct.TreeNode;

public class a572isSubtree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t == null)  return true;
        if(s == null || t == null)  return false;
        if(s.val == t.val && helper(s,t))   return true;
        return isSubtree(s.left,t) || isSubtree(s.right,t);
    }

    public boolean helper(TreeNode s, TreeNode t){
        if(s == null && t == null)  return true;
        if(s == null || t == null)  return false;
        if(s.val == t.val){
            return helper(s.left,t.left) && helper(s.right,t.right);
        }else{
            return false;
        }
    }
}
