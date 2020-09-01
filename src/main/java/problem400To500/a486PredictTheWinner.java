package problem400To500;

public class a486PredictTheWinner {
    public boolean PredictTheWinner(int[] nums) {
        return recur(nums, 0, nums.length-1, 1) >= 0;
    }

    public int recur(int[] num, int start, int end, int turn) {
        if (start == end) {
            return num[start] * turn;
        }
        int s = num[start] * turn + recur(num, start + 1, end, -turn);
        int e = num[end] * turn + recur(num, start, end - 1, -turn);
        return Math.max(s * turn, e * turn) * turn;
    }
}
