package problem200To300;

public class a209minSubArrayLen {

    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0)    return 0;
        if(nums.length == 1){
            if(nums[0]>=s)  return 1;
            return 0;
        }
        int i=0,j=1,cnt=nums[0],min=Integer.MAX_VALUE;
        for(;j<nums.length;){
            if(s>cnt){
                cnt+=nums[j++];
            }else{
                 min = Math.min(min,j-i);
                 cnt -= nums[i++];
            }
        }
        while(i<nums.length && cnt >=s){
            min = Math.min(min,j-i);
            cnt -= nums[i++];
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

}
