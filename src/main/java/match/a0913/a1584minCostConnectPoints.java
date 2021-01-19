package match.a0913;

import java.util.*;

// 可以用并查集去维护连通性，不过我没这么写（不会啊）
// 最小生成树
public class a1584minCostConnectPoints {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[][] stat = new int[n][n];
        for (int i = 0; i < points.length; i++) {
            int[] p = points[i];
            stat[i][i] = Integer.MAX_VALUE;
            for (int j = i+1; j < points.length; j++) {
                int[] a = points[j];
                stat[i][j] = Math.abs(a[0] - p[0]) + Math.abs(a[1] - p[1]);
                stat[j][i] = stat[i][j];
            }
        }
        List<Queue<int[]>> list = new ArrayList<>();
        for(int[] st : stat){
            Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o->o[0]));
            for(int i=0;i<n;i++){
                queue.add(new int[]{st[i],i});
            }
            list.add(queue);
        }
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        int res = 0;
        while (visited.size() != n){
            int min = Integer.MAX_VALUE,select = -1;
            for(int i : visited){
                Queue<int[]> queue = list.get(i);
                int[] p = queue.peek();
                while (p != null && visited.contains(p[1])){
                    queue.poll();
                    p = queue.peek();
                }
                if(p != null && p[0] < min){
                    min = p[0];
                    select = i;
                }
            }
            visited.add(list.get(select).peek()[1]);
            res += list.get(select).poll()[0];
        }
        return res;
    }
}
