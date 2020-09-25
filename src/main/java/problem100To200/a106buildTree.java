package problem100To200;

import struct.TreeNode;

public class a106buildTree {
    int[] inorder,postorder;
    int len;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        this.len = inorder.length;
        return build(0,len-1,0,len-1);
    }

    public TreeNode build(int il,int ir, int pl,int pr){
        if(il==ir){
            return new TreeNode(inorder[il]);
        }
        if(il > ir){
            return null;
        }
        int v  = postorder[pr];
        TreeNode root = new TreeNode(v);
        int im = ir;
        for(;im>il;im--){
            if(inorder[im] == postorder[pr]){
                break;
            }
        }
        root.left = build(il,im-1,pl,pr-(ir-im)-1);
        root.right = build(im+1,ir,pr-(ir-im),pr-1);
        return root;
    }
}
