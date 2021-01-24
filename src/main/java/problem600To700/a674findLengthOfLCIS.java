package problem600To700;

public class a674findLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0) return 0;
        int max = 1,pre =  1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] > nums[i-1]){
                pre++;
            }else{
                max = Math.max(max,pre);
                pre = 1;
            }
        }
        return Math.max(max,pre);
    }
}
