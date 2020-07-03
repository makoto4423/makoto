package problem100To200;

import struct.TreeNode;

public class a108sortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return help(nums, 0, nums.length-1);
    }

    public TreeNode help(int[] nums, int left, int right){
        if(left > right){
            return null;
        }
        int mid = (right+left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = help(nums,left,mid-1);
        root.right = help(nums,mid+1,right);
        return root;
    }
}
