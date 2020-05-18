package problem100To200;

// 第一时间想到暴力，效率点想到根据0的位置分组，不过递归感觉更慢
@Deprecated
public class a152maxProduct {
    public int maxProduct(int[] nums) {
        int maxF = 1,minF = 1,ans = Integer.MIN_VALUE;
        for(int i : nums){
            int xf = maxF,nf = minF;
            maxF = Math.max(nf*i,Math.max(i,xf*i));
            minF = Math.min(xf*i,Math.min(i,nf*i));
            ans = Math.max(maxF,ans);
        }
        return ans;
    }
}
