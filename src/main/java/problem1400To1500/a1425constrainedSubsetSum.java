package problem1400To1500;

import java.util.Arrays;

public class a1425constrainedSubsetSum {
    public int constrainedSubsetSum(int[] nums, int k) {
        int pos = -1, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && ans != 0) {
                pos = i - 1;
                break;
            }
            if (nums[i] >= 0) {
                ans += nums[i];
            }
        }
        int less = Integer.MIN_VALUE, temp = 0;
        for (int i = pos + 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int right = i;
                while (right < nums.length && nums[right] < 0) {
                    right++;
                }
                if(k > right-i){
                    i = right-1;
                    continue;
                }
                int[] dp = new int[right - i];
                Arrays.fill(dp, Integer.MIN_VALUE);
                for (int j = 0; j < k; j++) {
                    dp[j] = nums[i + j];
                }
                for (int j = k; j < right - i ; j++) {
                    for (int m = 1; m <= k; m++) {
                        dp[j] = Math.max(dp[j - m] + nums[i + j], dp[j]);
                    }
                }
                for (int j = right - i-1; j >= right - i - k && j >= 0; j--) {
                    less = Math.max(less, dp[j]);
                }
                i = right-1;
            } else {
                if (less == Integer.MIN_VALUE) {
                    ans += nums[i];
                } else {
                    temp += nums[i];
                    if (temp >= Math.abs(less)) {
                        if(ans >= Math.abs(less)){
                            ans += temp+less;
                        }else{
                            ans = temp + less;
                        }
                        less = Integer.MIN_VALUE;
                        temp = 0;
                    }
                }
            }
        }
        if(ans == 0){
            ans = Integer.MIN_VALUE;
            for(int i:nums){
                ans = Math.max(i, ans);
            }
        }
        return ans;
    }
}
