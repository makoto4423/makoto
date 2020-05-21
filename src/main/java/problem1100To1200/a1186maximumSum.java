package problem1100To1200;

// 两个dp数组，实在想不出来
@Deprecated
public class a1186maximumSum {

    public int maximumSum(int[] arr){
        int[] f = new int[arr.length];
        int[] g = new int[arr.length];
        f[0] = arr[0];
        // 不取Integer.MIN_VALUE是为了防止第一个数是负数导致相加变正
        g[0] =  -200001;
        for(int i=1;i<arr.length;i++){
            f[i] = Math.max(f[i-1]+arr[i],arr[i]);
            g[i] = Math.max(g[i-1]+arr[i],f[i-1]);
        }
        int res = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            res = Math.max(res,Math.max(f[i],g[i]));
        }
        return res;
    }


//    public int maximumSum(int[] arr) {
//        if (arr.length == 1) return arr[0];
//        int[] dp = new int[arr.length];
//        int amount = arr[0],min = arr[0];
//        dp[0] = arr[0];
//        for(int i=1;i<arr.length;i++){
//            min = Math.min(arr[i],min);
//            amount+=arr[i];
//            dp[i] = Math.max(dp[i-1],amount);
//            dp[i] = Math.max(dp[i],arr[i]);
//            dp[i] = Math.max(dp[i],amount-min);
//        }
//        return dp[arr.length-1];
//    }
}
