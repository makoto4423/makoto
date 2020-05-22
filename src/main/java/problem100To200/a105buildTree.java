package problem100To200;

import struct.TreeNode;

import java.util.HashMap;
import java.util.Map;


// 能想出这算法的雏形，但无法将其实现
@Deprecated
public class a105buildTree {

    public Map<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return help(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

    public TreeNode help(int[] preOrder,int[] inOrder,int preLeft,int preRight,int inLeft,int inRight){
        if(preLeft>preRight){
            return null;
        }
        TreeNode treeNode = new TreeNode(preOrder[preLeft]);
        int leftSize = map.get(preOrder[preLeft])-inLeft;
        treeNode.left = help(preOrder, inOrder, preLeft+1, preLeft+leftSize, inLeft, map.get(preOrder[preLeft])-1);
        treeNode.right = help(preOrder, inOrder, preLeft+leftSize+1, preRight, map.get(preOrder[preLeft])+1, inRight);
        return treeNode;
    }


}
