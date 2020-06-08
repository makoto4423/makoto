import problem900To1000.a990equationsPossible;
import struct.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class makoto2 {

    public static void main(String[] args){
        a990equationsPossible is = new a990equationsPossible();
        String[] arr = new String[100];
        String[] str = {"a==b","b!=c","c==a"};
        char[][] grid = {
                {'0','0','0','1'},
                {'1','1','0','1','1'},
                {'1','1','1','1','1'},
                {'0','1','1','1','1'},
                {'0','1','1','1'}
        };
        int[][] grid2 = {
//                {1,2,3},
//                {4,5,6},{7,8,9}
                {1,2,3,4},{5,6,7,8},{9,10,11,12}
        };
        int[] ints = {4, 6, 7, 7};
        int[] ints1 = {9,3,15,20,7};
        TreeNode node =  initNode();
        TreeNode node2 =  initNode2();
        int[][] arr2 = {
                {1,2},{1,3},{2,4}
        };
        List<String> list = new ArrayList<>(Arrays.asList(str));
        System.out.println(is.equationsPossible(str));
    }

    public static TreeNode initNode(){
        TreeNode b = new TreeNode(4);
        b.right = new TreeNode(2);
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(0);
        b.left = a;
        return b;
    }

    public static TreeNode initNode2(){
        TreeNode b = new TreeNode(4);
        b.left = new TreeNode(1);
        b.right = new TreeNode(2);
        return b;
    }
}
