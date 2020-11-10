package problem1000To1100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 本质还是八皇后，不过内存溢出逼着用Map我是没想到的了
public class a1001gridIllumination {

    int[] xGrid = {-1, -1, -1, 0, 1, 1, 1, 0, 0};
    int[] yGrid = {-1, 0, 1, 1, 1, 0, -1, -1, 0};
    Map<Integer, Integer> row, line, up, down;
    Set<String> set;

    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        set = new HashSet<>();
        row = new HashMap<>();
        line = new HashMap<>();
        up = new HashMap<>();
        down = new HashMap<>();
        for (int[] l : lamps) {
            set.add(l[0] + "," + l[1]);
            row.put(l[0], row.getOrDefault(l[0], 0) + 1);
            line.put(l[1], line.getOrDefault(l[1], 0) + 1);
            up.put(l[0] + l[1], up.getOrDefault(l[0] + l[1], 0) + 1);
            down.put(N - 1 - l[1] + l[0], down.getOrDefault(N - 1 - l[1] + l[0], 0) + 1);
        }
        int len = queries.length;
        int[] res = new int[len];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0], y = queries[i][1];
            if (row.containsKey(x) || line.containsKey(y) || up.containsKey(x + y) || down.containsKey(N - 1 - y + x)) {
                res[i] = 1;
            } else {
                res[i] = 0;
            }
            for (int j = 0; j < 9; j++) {
                int m = x + xGrid[j], n = y + yGrid[j];
                if (set.contains(m + "," + n)) {
                    set.remove(m + "," + n);
                    int temp = row.getOrDefault(m, 0) - 1;
                    if (temp <= 0) {
                        row.remove(m);
                    } else {
                        row.put(m, temp);
                    }
                    temp = line.getOrDefault(n, 0) - 1;
                    if (temp <= 0) {
                        line.remove(n);
                    } else {
                        line.put(n, temp);
                    }
                    temp = up.getOrDefault(m + n, 0) - 1;
                    if (temp <= 0) {
                        up.remove(m + n);
                    } else {
                        up.put(m + n, temp);
                    }
                    temp = down.getOrDefault(N - 1 - n + m, 0) - 1;
                    if (temp <= 0) {
                        down.remove(N - 1 - n + m);
                    } else {
                        down.put(N - 1 - n + m, temp);
                    }
                }
            }
        }
        return res;
    }
}
