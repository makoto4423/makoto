package problem1200To1300;


import java.util.*;

/**
 * 图，拓扑排序
 * 吐了，看着答案写都调了半天
 */
@Deprecated
public class a1203sortItems {

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int len = group.length;
        for (int i = 0; i < len; i++) {
            if (group[i] == -1) {
                group[i] = m;
                m++;
            }
        }
        List<List<Integer>> groupAdj = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            groupAdj.add(new ArrayList<>());
        }
        int[] groupsInDegree = new int[m];
        for (int i = 0; i < len; i++) {
            int curGroup = group[i];
            for (int before : beforeItems.get(i)) {
                if (group[before] != curGroup) {
                    groupAdj.get(group[before]).add(curGroup);
                    groupsInDegree[curGroup]++;
                }
            }
        }
        List<List<Integer>> itemAdj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            itemAdj.add(new ArrayList<>());
        }
        int[] itemInDegree = new int[n];
        for (int i = 0; i < beforeItems.size(); i++) {
            for (int before : beforeItems.get(i)) {
                itemAdj.get(before).add(i);
                itemInDegree[i]++;
            }
        }
        List<Integer> groupTopology = topology(groupAdj, groupsInDegree, m);
        if (groupTopology.isEmpty()) {
            return new int[]{};
        }
        List<Integer> itemTopology = topology(itemAdj, itemInDegree, n);
        if (itemTopology.isEmpty()) {
            return new int[]{};
        }
        Map<Integer, List<Integer>> groupToItem = new HashMap<>();
        for (Integer integer : itemTopology) {
            groupToItem.computeIfAbsent(group[integer], (key) -> new ArrayList<>()).add(integer);
        }
        List<Integer> res = new ArrayList<>();
        for (int g : groupTopology) {
            res.addAll(groupToItem.getOrDefault(g,Collections.emptyList()));
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public List<Integer> topology(List<List<Integer>> adj, int[] degree, int n) {
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int front = queue.poll();
            res.add(front);
            for (int aft : adj.get(front)) {
                degree[aft]--;
                if (degree[aft] == 0) {
                    queue.add(aft);
                }
            }
        }
        if (res.size() == n) {
            return res;
        }
        return Collections.emptyList();
    }
}
