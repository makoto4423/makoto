package interview1To100;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class a0405isValidBST {
    List<Integer> list = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        if(root == null)    return true;
        recur(root);
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i) >= list.get(i+1)){
                return false;
            }
        }
        return true;
    }

    public void recur(TreeNode root){
        if(root.left != null){
            recur(root.left);
        }
        list.add(root.val);
        if(root.right != null){
            recur(root.right);
        }
    }
}
