package problem1000To1100;

public class a1052maxSatisfied {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int n = customers.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] != 1) sum += customers[i];
        }
        int more = 0;
        for (int i = 0; i < X; i++) {
            if (grumpy[i] == 1) more += customers[i];
        }
        int res = sum + more;
        for (int i = X; i < n; i++) {
            if (grumpy[i] == 1) more += customers[i];
            if (grumpy[i - X] == 1) more -= customers[i - X];
            res = Math.max(res, sum + more);
        }
        return res;
    }
}
