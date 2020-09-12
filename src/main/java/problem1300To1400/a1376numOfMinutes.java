package problem1300To1400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a1376numOfMinutes {
    int[] manager;
    int[] informTime;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        this.manager = manager;
        this.informTime = informTime;
        Tree tree = recur(headID);
        return calculate(tree);
    }

    // 自顶向下构建树会超时，递归会循环遍历manager
    public Tree recur(int headID) {
        Map<Integer, Tree> map = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            Tree now = map.getOrDefault(i, new Tree(i));
            Tree parent = map.getOrDefault(manager[i], new Tree(manager[i]));
            parent.child.add(now);
            map.put(i, now);
            map.put(manager[i], parent);
        }
        Tree root = map.get(headID);
        root.index = headID;
        return root;
    }

    public int calculate(Tree tree) {
        int temp = 0;
        for (Tree ch : tree.child) {
            temp = Math.max(calculate(ch), temp);
        }
        return temp + informTime[tree.index];
    }

    static class Tree {

        public int index;
        public List<Tree> child;

        public Tree(int index) {
            this.index = index;
            this.child = new ArrayList<>();
        }
    }
}
