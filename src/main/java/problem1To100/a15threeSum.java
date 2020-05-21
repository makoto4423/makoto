package problem1To100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Deprecated
public class a15threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3)    return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0) break;
            if(i>0 && nums[i-1] == nums[i]) continue;
            int left=i+1,right=nums.length-1;
            while(left < right){
                if(nums[i]+nums[left]+nums[right] == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);list.add(nums[left]);list.add(nums[right]);
                    res.add(list);
                    while(left<right && nums[left]==nums[left+1]) left++;
                    while(left<right && nums[right]==nums[right-1]) right--;
                    left++;right--;
                }else if(nums[i]+nums[left]+nums[right] > 0){
                    right--;
                }else {
                    left++;
                }
            }
        }
        return res;
    }
}
