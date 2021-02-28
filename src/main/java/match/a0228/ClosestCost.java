package match.a0228;

import java.util.Arrays;

// 回溯
public class ClosestCost {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        Arrays.sort(toppingCosts);
        int res = Integer.MAX_VALUE, dif = Integer.MAX_VALUE;
        for (int base : baseCosts) {
            int temp = recur(toppingCosts, base, 0, target, false);
            if (Math.abs(temp - target) < dif) {
                res = temp;
                dif = Math.abs(temp - target);
            } else if (Math.abs(temp - target) == dif) {
                res = Math.min(temp, res);
            }
        }
        return res;
    }

    public int recur(int[] toppingCosts, int cost, int index, int target, boolean same) {
        if (index == toppingCosts.length) {
            return cost;
        }
        if (cost == target) return cost;
        int ret = -1, dif = Integer.MAX_VALUE;
        for (int i = index; i < toppingCosts.length; i++) {
            if (cost + toppingCosts[i] > target) {
                if (Math.abs(cost + toppingCosts[i] - target) < Math.abs(cost - target)) {
                    if (dif > Math.abs(cost + toppingCosts[i] - target)) {
                        dif = Math.abs(cost + toppingCosts[i] - target);
                        ret = cost + toppingCosts[i];
                    }
                } else {
                    if (dif > Math.abs(cost - target)) {
                        dif = Math.abs(cost - target);
                        ret = cost;
                    }
                    int temp = recur(toppingCosts, cost, i + 1, target, false);
                    if (Math.abs(temp - target) < dif) {
                        ret = temp;
                        dif = Math.abs(temp - target);
                    } else if (dif == Math.abs(temp - target)) {
                        ret = Math.min(temp, ret);
                    }
                }
            } else {
                int temp = recur(toppingCosts, cost + toppingCosts[i], i + 1, target, false);
                if (Math.abs(temp - target) < dif) {
                    ret = temp;
                    dif = Math.abs(temp - target);
                } else if (dif == Math.abs(temp - target)) {
                    ret = Math.min(temp, ret);
                }
                if (!same) {
                    temp = recur(toppingCosts, cost + toppingCosts[i], i, target, true);
                    if (Math.abs(temp - target) < dif) {
                        ret = temp;
                        dif = Math.abs(temp - target);
                    } else if (dif == Math.abs(temp - target)) {
                        ret = Math.min(temp, ret);
                    }
                }
            }
        }
        return ret;
    }
}
