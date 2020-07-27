package problem600To700;

import struct.TreeNode;

public class a654constructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int len = nums.length;
        if(len == 0)    return null;
        return recur(nums, 0, len-1);
    }

    public TreeNode recur(int[] nums, int left, int right){
        if(left == right){
            return new TreeNode(nums[left]);
        }
        if(left > right){
            return null;
        }
        int val = left;
        for(int i=left+1;i<=right;i++){
            if(nums[i] > nums[val]){
                val = i;
            }
        }
        TreeNode node = new TreeNode(nums[val]);
        node.left = recur(nums, left, val-1);
        node.right = recur(nums, val+1, right);
        return node;
    }

}
