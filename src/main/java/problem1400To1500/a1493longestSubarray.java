package problem1400To1500;

public class a1493longestSubarray {
    public int longestSubarray(int[] nums) {
        boolean pre = false;
        int res = 0,temp=0;
        for(int i=0;i<nums.length;i++){
            if(i == 0){
                if(nums[0] == 1){
                    temp++;
                }else{
                    pre = true;
                }
            }else if(nums[i] == 0 && !pre){
                pre = true;
            }else if(nums[i] == 0 && pre){
                res = Math.max(res, temp);
                for(int j=i-1;j>=0;j--){
                    if(nums[j] == 0){
                        temp = i-j-1;break;
                    }
                }
            }else{
                temp++;
            }
        }
        return pre ? Math.max(res, temp) : temp-1;
    }
}
