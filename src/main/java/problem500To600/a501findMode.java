package problem500To600;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class a501findMode {

    public int[] findMode(TreeNode root) {
        if(root == null)    return new int[0];
        List<Integer> list = new ArrayList<>();
        ergodic(root, list);
        List<Integer> res = new ArrayList<>();
        int cnt = 0;
        for(int i=0;i<list.size();){
            int temp = 1;
            int j=i+1;
            for(;j<list.size();j++){
                if(!list.get(j).equals(list.get(i))){
                    break;
                }
                temp++;
            }
            if(temp > cnt){
                res = new ArrayList<>();
                res.add(list.get(i));
                cnt = temp;
            }else if(temp == cnt){
                res.add(list.get(i));
            }
            i=j;
        }
        int[] arr = new int[res.size()];
        for(int i=0;i<res.size();i++){
            arr[i] = res.get(i);
        }
        return arr;
    }

    public void ergodic(TreeNode node,List<Integer> list){
        if(node.left != null){
            ergodic(node.left, list);
        }
        list.add(node.val);
        if(node.right != null){
            ergodic(node.right, list);
        }
    }
}
