package problem1To100;

@Deprecated
// 类似于之前的布隆过滤器，然而太懒了
public class a41firstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0) {
                nums[i] = len + 1;
            }
        }
        for (int i = 0; i < len; i++) {
            int num = Math.abs(nums[i]);
            if(num <= len){
                nums[num-1] = -Math.abs(nums[num-1]);
            }
        }
        for(int i=0;i<len;i++){
            if(nums[i] >= 0){
                return i+1;
            }
        }
        return len+1;
    }
}
