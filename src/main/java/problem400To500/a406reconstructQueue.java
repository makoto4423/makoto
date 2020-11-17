package problem400To500;

import java.util.*;

public class a406reconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o2[0] - o1[0];
            }
            return o1[1] - o2[1];
        });
        queue.addAll(Arrays.asList(people));
        List<int[]> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            list.add(p[1], p);
        }
        return list.toArray(new int[list.size()][]);
    }
}
