public class a1716massage {
    public int massage(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] res = new int[nums.length];
        res[0] = nums[0];res[1]=Math.max(nums[1],nums[0]);
        for(int i=2; i < nums.length; i++){
            res[i] = Math.max(res[i - 1], nums[i] + res[i - 2]);
        }
        return res[nums.length-1];
    }
}
