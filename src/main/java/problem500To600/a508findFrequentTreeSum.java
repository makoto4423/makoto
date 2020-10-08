package problem500To600;

import struct.TreeNode;

import java.util.*;

public class a508findFrequentTreeSum {
    List<Integer> list;
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null)    return new int[]{};
        list = new ArrayList<>();
        recur(root);
        ergodic(root);
        Collections.sort(list);
        int cnt = 0;
        List<Integer> l = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            int temp = 1;
            for(int j=i+1;j<list.size();j++){
                if(list.get(i).equals(list.get(j))){
                    temp++;
                    i++;
                }
            }
            if(temp > cnt){
                l = new ArrayList<>();
                cnt = temp;
                l.add(list.get(i));
            }else if(temp == cnt){
                l.add(list.get(i));
            }
        }
        int[] res = new int[l.size()];
        for(int i=0;i<res.length;i++){
            res[i] = l.get(i);
        }
        return res;
    }

    public void recur(TreeNode node){
        int left = 0,right = 0;
        if(node.left != null){
            recur(node.left);
            left = node.left.val;
        }
        if(node.right != null){
            recur(node.right);
            right = node.right.val;
        }
        node.val = node.val+left+right;
    }

    public void ergodic(TreeNode node){
        if(node.left != null){
            ergodic(node.left);
        }
        if(node.right != null){
            ergodic(node.right);
        }
        list.add(node.val);
    }
}
