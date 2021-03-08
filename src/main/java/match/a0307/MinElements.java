package match.a0307;

import java.util.Arrays;

public class MinElements {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = Arrays.stream(nums).mapToLong(i -> Long.parseLong(i + "")).sum();
        long dif = Math.abs(sum - goal);
        if (dif % limit == 0) {
            return (int) (dif / limit);
        }
        return (int) (dif / limit + 1);
    }
}
