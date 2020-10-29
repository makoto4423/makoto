package problem1To100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 傻了，连回溯都不会写了
 */
@Deprecated
public class a18fourSum {
    List<List<Integer>> res;
    int[] nums;
    int target;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        res = new ArrayList<>();
        this.nums = nums;
        this.target = target;
        Arrays.sort(nums);
        recur(new ArrayList<>(),0,0);
        return res;
    }

    public void recur(List<Integer> list,int index, int cur){
        if(list.size() == 4){
            if(cur == target){
                res.add(new ArrayList<>(list));
                return;
            }
        }
        for(int i=index;i<nums.length;i++){
            if(nums.length- i < 4-list.size())  return;
            if(i != index && nums[i] == nums[i-1]) continue;
            if(i < nums.length - 1 && cur + nums[i] + (3 - list.size()) * nums[i + 1] > target)return;
            if(i < nums.length - 1 && cur + nums[i] + (3 - list.size()) * nums[nums.length - 1] < target)continue;
            list.add(nums[i]);
            recur(list,i+1,cur+nums[i]);
            list.remove(list.size()-1);
        }
    }
}
