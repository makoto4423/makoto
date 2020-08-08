package problem1To100;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 算不上hard，写多了看完题目就知道该中序遍历然后替换
public class a99recoverTree {
    List<Integer> list;
    public void recoverTree(TreeNode root) {
        list = new ArrayList<>();
        help(root);
        int small = 0, big = 0;
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)>list.get(i+1)){
                big = list.get(i);
                break;
            }
        }
        for(int i=list.size()-1;i>=1;i--){
            if(list.get(i) < list.get(i-1)){
                small = list.get(i);break;
            }
        }
        replace(root, big, small);
    }

    public void help(TreeNode node){
        if(node.left != null){
            help(node.left);
        }
        list.add(node.val);
        if(node.right != null){
            help(node.right);
        }
    }

    public void replace(TreeNode node, int big, int small){
        if(node.left != null){
            replace(node.left, big, small);
        }
        if(node.val == big){
            node.val = small;
        }else if(node.val == small){
            node.val = big;
        }
        if(node.right != null){
            replace(node.right, big, small);
        }

    }
}
