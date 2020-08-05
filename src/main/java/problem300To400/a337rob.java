package problem300To400;

import struct.TreeNode;

@Deprecated
public class a337rob {
    public int rob(TreeNode root) {
        int[] arr = dfs(root);
        return Math.max(arr[0],arr[1]);
    }

    public int[] dfs(TreeNode node){
        if(node == null){
            return new int[]{0,0};
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int selected = node.val + left[1] + right[1];
        int notSelected = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        return new int[]{selected, notSelected};
    }
}
