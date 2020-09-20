package match.a0919;

import java.util.Arrays;

/**
 * 这计算频率的方法。。。
 */
@Deprecated
public class a5505maxSumRangeQuery {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int[] stat = new int[nums.length];
        int[][] te = new int[nums.length][2];
        for (int[] re : requests) {
            te[re[0]][0]++;
            te[re[1]][1]--;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += te[i][0];
            stat[i] = sum;
            sum += te[i][1];
        }
        Arrays.sort(stat);
        Arrays.sort(nums);
        int res = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            long temp = nums[i] * stat[i];
            temp += res;
            temp %= 1000000007;
            res = (int) temp;
        }
        return res;
    }
//    public int maxSumRangeQuery(int[] nums, int[][] requests) {
//        int[] stat = new int[nums.length];
//        for (int[] re : requests) {
//            for (int i = re[0]; i <= re[1]; i++) {
//                stat[i]++;
//            }
//        }
//        Arrays.sort(stat);
//        Arrays.sort(nums);
//        int res = 0;
//        for (int i = nums.length - 1; i >= 0; i--) {
//            long temp = nums[i]*stat[i];
//            temp += res;
//            temp %= 1000000007;
//            res = (int) temp;
//        }
//        return res;
//    }
}
