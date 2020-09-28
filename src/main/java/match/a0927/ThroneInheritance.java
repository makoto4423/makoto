package match.a0927;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// 第三题比第二题还简单
public class ThroneInheritance {
    String head;
    Map<String, Tree> map;

    public ThroneInheritance(String kingName) {
        head = kingName;
        map = new HashMap<>();
        Tree tree = new Tree(kingName);
        map.put(kingName, tree);
    }

    public void birth(String parentName, String childName) {
        Tree tree = map.get(parentName);
        tree.child.add(childName);
        Tree child = new Tree(childName);
        map.put(childName, child);
    }

    public void death(String name) {
        map.get(name).isDead = true;
    }

    public List<String> getInheritanceOrder() {
        List<String> res = new ArrayList<>();
        recur(res, head);
        return res;
    }

    public void recur(List<String> res, String name) {
        Tree tree = map.get(name);
        if (!tree.isDead) {
            res.add(tree.name);
        }
        List<String> child = tree.child;
        for (String ch : child) {
            recur(res, ch);
        }
    }

    static class Tree {
        String name;
        boolean isDead;
        List<String> child;

        public Tree(String name) {
            this.name = name;
            this.isDead = false;
            this.child = new ArrayList<>();
        }
    }
}
