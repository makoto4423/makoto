package problem300To400;


// 当[1,x-1]被覆盖，x位于数组中时，则代表[1,2*x-1]会被覆盖
@Deprecated
public class a330minPatches {
    public int minPatches(int[] nums, int n) {
        long x = 1;
        int index = 0;
        int res = 0;
        while (x <= n) {
            if (index < nums.length && nums[index] <= x) {
                x += nums[index];
                index++;
            } else {
                x *= 2;
                res++;
            }
        }
        return res;
    }
}
