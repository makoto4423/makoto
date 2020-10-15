package problem100To200;

import struct.node.Node;

public class a116connect {
    public Node connect(Node root) {
        if(root == null)    return null;
        if(root.left == null)   return root;
        root.left.next = root.right;
        if(root.next != null){
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}
