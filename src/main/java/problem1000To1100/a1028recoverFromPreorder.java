package problem1000To1100;

import struct.TreeNode;

public class a1028recoverFromPreorder {
    int pos = 0;

    public TreeNode recoverFromPreorder(String S) {
        StringBuilder sb = new StringBuilder();
        sb.append(S.charAt(0));
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i - 1) == '-' && S.charAt(i) != '-') {
                sb.append('E');
            }
            sb.append(S.charAt(i));
        }
        String s = sb.toString();
        return dp(s,0);
    }

    public TreeNode dp(String s, int dep) {
        if (pos == 0) {
            int index = s.indexOf('-');
            if(index == -1){
                index = s.length();
            }
            pos = index;
            TreeNode root = new TreeNode(Integer.parseInt(s.substring(0, index)));
            root.left = dp(s, 1);
            root.right = dp(s, 1);
            return root;
        }
        if(pos == s.length()){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dep; i++) {
            sb.append('-');
        }
        String tag = sb.toString() + "E";
        int index = s.indexOf(tag, pos);
        if (index != pos) {
            return null;
        }
        int behind = s.indexOf('-', index+tag.length());
        if(behind == -1){
            behind = s.length();
        }
        pos =behind;
        TreeNode node = new TreeNode(Integer.parseInt(s.substring(index+tag.length(),behind)));
        node.left = dp(s, dep+1);
        node.right = dp(s, dep+1);
        return node;
    }
}
