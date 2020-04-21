package interview1To100;

// 可以二分，懒得想了
public class a53missingNumber {
    public int missingNumber(int[] nums) {
        for(int i=0; i<nums.length; i++){
            if(nums[i] != i){
                return i;
            }
        }
        return nums.length;
    }
}
