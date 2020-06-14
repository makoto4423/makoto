package problem1300To1400;

import java.util.Arrays;

// 前缀和是写出来了，但是一步步枚举反而卡住了。。。。
@Deprecated
public class a1300findBestValue {
    public int findBestValue(int[] arr, int target) {
        int len = arr.length;
        Arrays.sort(arr);
        int[] dp = new int[len+1];
        dp[0] = 0;
        for(int i=1;i<=arr.length;i++){
            dp[i] = dp[i-1]+arr[i-1];
        }
        int right = arr[len-1];
        int less = target,res = 0;
        for(int i=1;i<=right;i++){
            int index = Arrays.binarySearch(arr,i);
            if(index < 0){
                index = -index-1;
            }
            int dif = dp[index]+(len-index)*i;
            if(less > Math.abs(dif-target)){
                less = Math.abs(dif-target);
                res = i;
            }
        }
        return res;
    }
}
