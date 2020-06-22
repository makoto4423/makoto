package problem1400To1500;

public class a1470shuffle {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2*n];
        for(int i=0;i<n;i++){
            ans[2*i] = nums[i];
            ans[2*i+1] = nums[i+n];
        }
        return ans;
    }
}
