public class a1716massage {
    public int massage(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] res = new int[nums.length+1];
        res[0] = nums[0];res[1]=nums[1];res[2]=nums[2];
        for(int i=2; i < nums.length; i++){

        }
        return res[nums.length];
    }
}
