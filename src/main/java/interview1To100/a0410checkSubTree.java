package interview1To100;

import struct.TreeNode;

// 题目描述，很大的树，然后递归解决，无力吐槽
public class a0410checkSubTree {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        return check(t1,t2);
    }

    public boolean check(TreeNode t1, TreeNode t2){
        if(t2 == null)  return true;
        if(t1 == null)  return false;
        if(t1.val == t2.val){
            return check(t1.left,t2.left) && check(t1.right,t2.right);
        }else if(t1.left != null && t1.left.val == t2.val){
            return check(t1.left,t2);
        }else if(t1.right != null && t1.right.val == t2.val){
            return check(t1.right, t2);
        }else{
            return check(t1.left,t2) || check(t1.right,t2);
        }
    }

}
