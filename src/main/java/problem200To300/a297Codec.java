package problem200To300;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// 超出内存限制，但答案整体思路和我写的并无差异，放置一边
@Deprecated
public class a297Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<TreeNode> node = new ArrayList<>();
        node.add(root);
        List<String> res = new ArrayList<>();
        arrange(node,res);
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.trim();
        data = data.substring(1,data.length()-1);
        String[] ss = data.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(ss));
        return spell(list,0);
    }


    public void arrange(List<TreeNode> node, List<String> res){
        boolean nu = false;
        List<TreeNode> child = new ArrayList<>();
        for(TreeNode n : node){
            if(n == null){
                res.add("null");
                child.add(null);
                child.add(null);
            }else{
                res.add(String.valueOf(n.val));
                child.add(n.left);
                child.add(n.right);
                nu = nu || (n.left != null || n.right != null);
            }
        }
        if(nu){
            arrange(child,res);
        }
    }


    public TreeNode spell(List<String> list,int index){
        String s = list.get(index);
        s = s.trim();
        if(s.equals("null")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(s));
        if(index*2+1<list.size()){
            node.left = spell(list,2*index+1);
            node.right = spell(list, 2*index+2);
        }
        return node;
    }
}
