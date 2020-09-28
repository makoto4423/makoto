package problem100To200;

import struct.node.Node;

import java.util.ArrayList;
import java.util.List;

public class a117connect {
    public Node connect(Node root) {
        if(root == null)    return null;
        List<Node> nodes = new ArrayList<>();
        nodes.add(root);
        recur(nodes);
        return root;
    }

    public void recur(List<Node> nodes){
        if(nodes.size() == 0){
            return;
        }
        List<Node> child = new ArrayList<>();
        int i=0;
        for(;i<nodes.size()-1;i++){
            Node node = nodes.get(i);
            node.next = nodes.get(i+1);
            if(node.left != null){
                child.add(node.left);
            }
            if(node.right != null){
                child.add(node.right);
            }
        }
        Node last = nodes.get(i);
        if(last.left != null){
            child.add(last.left);
        }
        if(last.right != null){
            child.add(last.right);
        }
        recur(child);
    }
}
