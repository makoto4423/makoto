package problem1To100;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class a98isValidBST {

    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        scan(root,list);
        for(int i=0; i<list.size()-1; i++){
            if(list.get(i)>=list.get(i+1)){
                return false;
            }
        }
        return true;
    }

    public void scan(TreeNode root, List<Integer> list){
        if(root == null) return;
        if(root.left != null){
            scan(root.left, list);
        }
        list.add(root.val);
        if(root.right != null){
            scan(root.right, list);
        }
    }
}
