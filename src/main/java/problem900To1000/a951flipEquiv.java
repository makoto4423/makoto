package problem900To1000;

import struct.TreeNode;

public class a951flipEquiv {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)  return true;
        if(root1 == null || root2 == null)  return false;
        if(root1.val != root2.val)  return false;
        int left1 = -1,left2 = -1, right2 = -1;
        if(root1.left != null)  left1 = root1.left.val;
        if(root2.left != null)  left2 = root2.left.val;
        if(root2.right != null) right2 = root2.right.val;
        if(left1 == left2){
            return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        }
        if(left1 == right2){
            return flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
        }
        return false;
    }
}
