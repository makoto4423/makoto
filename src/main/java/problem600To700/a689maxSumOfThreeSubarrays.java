package problem600To700;

public class a689maxSumOfThreeSubarrays {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        // 此处不是nums的数组长度
        int len = nums.length - k + 1;
        // 求出以当前索引开始，k位子数组的和
        int[] dp = new int[len];
        int temp = 0;
        for (int i = 0; i < k; i++) {
            temp += nums[i];
        }
        dp[0] = temp;
        for (int i = 1; i < len; i++) {
            temp = temp - nums[i - 1] + nums[i + k - 1];
            dp[i] = temp;
        }
        int max1 = 0;
        int index1 = -1;
        // 根据上面求出的dp数组，求出以当前索引开始，不重复*两个*子数组的最大和，
        // 二维是记录当前和的情况下，第0位数的索引，第1位数的索引即为本身，不用记录
        // 从k开始，k之前的无法获取不重复的子数组，
        // 结束位是len-k，索引超过该值则无法获取到三个不重复的子数组
        int[][] dp2 = new int[len][2];
        for (int i = k; i < len - k; i++) {
            if (max1 < dp[i - k]) {
                max1 = dp[i - k];
                index1 = i - k;
            }
            dp2[i][0] = max1 + dp[i];
            dp2[i][1] = index1;
        }
        int[] res = new int[3];
        int max2 = 0, max = 0;
        int index2 = -1;
        // 根据上面求出的dp2，求三个不重复子数组的最大值
        for (int i = 2 * k; i < len; i++) {
            // 求出*当前索引*下，两个不重复数组的最大值，并记录dp2的索引
            if (max2 < dp2[i - k][0]) {
                max2 = dp2[i - k][0];
                index2 = i - k;
            }
            if (max < max2 + dp[i]) {
                max = max2 + dp[i];
                res[0] = dp2[index2][1];
                res[1] = index2;
                res[2] = i;
            }
        }
        return res;
    }
}
