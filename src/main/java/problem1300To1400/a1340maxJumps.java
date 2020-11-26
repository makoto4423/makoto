package problem1300To1400;

public class a1340maxJumps {
    int[] dp, arr;
    int d, len;

    public int maxJumps(int[] arr, int d) {
        len = arr.length;
        this.arr = arr;
        this.d = d;
        dp = new int[len];
        int res = 0;
        for(int i=0;i<len;i++){
            if(dp[i] == 0){
                recur(i);
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    public void recur(int i) {
        int l = i - 1, r = i + 1, left = 0, right = 0;
        for (; l >= 0 && i - l <= d; l--) {
            if (arr[i] <= arr[l]) break;
            if (dp[l] == 0) {
                recur(l);
            }
            left = Math.max(left, dp[l]);
        }
        for (; r < len && r - i <= d; r++) {
            if (arr[i] <= arr[r]) break;
            if (dp[r] == 0) {
                recur(r);
            }
            right = Math.max(right, dp[r]);
        }
        if (left == 0 && right == 0) {
            dp[i] = 1;
        } else {
            dp[i] = Math.max(left, right) + 1;
        }
    }

}
