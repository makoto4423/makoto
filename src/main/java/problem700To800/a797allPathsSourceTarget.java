package problem700To800;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a797allPathsSourceTarget {
    int[][] graph;
    List<List<Integer>> res;
    int n;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.graph = graph;
        n = graph.length;
        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        recur(0, list);
        return res;
    }

    public void recur(int start, List<Integer> list) {
        if (start == n - 1) {
            res.add(new ArrayList<>(list));
            return;
        }
        int[] arr = graph[start];
        for (int i : arr) {
            list.add(i);
            recur(i, list);
            list.remove(list.size() - 1);
        }
    }

}
