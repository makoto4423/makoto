package match.a0927;

/**
 * 这道题就是考验耐心。。。
 */
public class a1599minOperationsMaxProfit {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int profit = 0, temp = 0, res = 0, wait = 0;
        for (int i : customers) {
            wait += i;
            int get = 0;
            if (wait >= 4) {
                wait -= 4;
                get = 4 * boardingCost - runningCost;
            } else {
                get = wait * boardingCost - runningCost;
                wait = 0;
            }
            profit = profit + get;
            if (get <= 0 && profit > 0) {
                res = temp;
            }
            temp++;
        }
        res = Math.max(res, temp);
        if (wait > 0 && 4 * boardingCost - runningCost > 0) {
            int use = wait / 4;
            profit += (wait / 4 * 4) * boardingCost - runningCost;
            int yu = (wait % 4) * boardingCost - runningCost;
            if (yu > 0) {
                profit += yu;
                use++;
            }
            res += use;
        }
        return profit > 0 ? res : -1;
    }
}
