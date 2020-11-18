package problem100To200;

import java.util.ArrayList;
import java.util.List;

public class a134canCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int[] last = new int[len];
        int la = 0;
        for (int i = 0; i < len; i++) {
            last[i] = gas[i] - cost[i];
            la += last[i];
        }
        if (la < 0) return -1;
        int pre = last[0], index = 0;
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i < len; i++) {
            if (pre >= 0 && last[i] >= 0) {
                pre += last[i];
            } else if (pre < 0 && last[i] < 0) {
                pre += last[i];
            } else {
                list.add(new int[]{pre, index});
                index = i;
                pre = last[i];
            }
        }
        list.add(new int[]{pre, index});
        len = list.size();
        if (len == 1) return 0;
        if (list.get(0)[0] >= 0 && list.get(len - 1)[0] >= 0) {
            list.get(0)[0] += list.get(len - 1)[0];
            list.get(0)[1] = list.get(len - 1)[1];
            list.remove(len - 1);
            len = list.size();
        }
        int i = 0;
        for (; i < len; i++) {
            la = list.get(i)[0];
            if (la < 0) continue;
            int j = i + 1;
            for (; j < len; j++) {
                la += list.get(j)[0];
                if (la < 0) break;
            }
            if (j == len) return list.get(i)[1];
        }
        return -1;
    }
}
