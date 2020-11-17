package offer;

public class a03findRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        boolean[] visit = new boolean[nums.length + 1];
        for (int i : nums) {
            if (!visit[i]) {
                visit[i] = true;
            } else {
                return i;
            }
        }
        return -1;
    }
}
