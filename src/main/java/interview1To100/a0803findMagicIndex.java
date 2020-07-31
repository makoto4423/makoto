package interview1To100;

// 写着有序明摆着叫我写二分，然而手上有事，随便应付了事吧
public class a0803findMagicIndex {
    public int findMagicIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i] == i){
                return i;
            }
        }
        return -1;
    }
}
