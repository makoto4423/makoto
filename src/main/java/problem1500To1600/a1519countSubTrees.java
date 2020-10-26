package problem1500To1600;

import java.util.*;

/**
 * 这题目有毒，序列竟然会是倒序，遍历一遍还要去找出顺序
 */
public class a1519countSubTrees {

    int[] res;
    String labels;

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        this.labels = labels;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int i = queue.poll();
            List<Integer> l = list.get(i);
            for (Integer j : l) {
                list.get(j).remove(new Integer(i));
            }
            queue.addAll(list.get(i));
        }
        res = new int[n];
        recur(list, 0);
        return res;
    }

    public Map<Character, Integer> recur(List<List<Integer>> list, int index) {
        List<Integer> child = list.get(index);
        Map<Character, Integer> map = new HashMap<>();
        for (Integer j : child) {
            Map<Character, Integer> temp = recur(list, j);
            for (Character ch : temp.keySet()) {
                map.put(ch, map.getOrDefault(ch, 0) + temp.get(ch));
            }
        }
        map.put(labels.charAt(index), map.getOrDefault(labels.charAt(index), 0) + 1);
        res[index] = map.get(labels.charAt(index));
        return map;
    }

}
