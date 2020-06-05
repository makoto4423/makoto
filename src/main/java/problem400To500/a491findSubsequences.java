package problem400To500;

import java.util.ArrayList;
import java.util.List;

public class a491findSubsequences {
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> findSubsequences(int[] nums) {
        this.nums = nums;
        help(0,new ArrayList<>());
        return res;
    }

    public void help(int pos, List<Integer> list){
        if(pos == nums.length){
            if(list.size() > 1){
                res.add(new ArrayList<>(list));
            }
            return;
        }
        if(list.size() == 0 || nums[pos]>=list.get(list.size()-1)){
            list.add(nums[pos]);
            help(pos+1,list);
            list.remove(list.size()-1);
        }
        if(list.size() != 0 && nums[pos] == list.get(list.size()-1)){
            return;
        }
        help(pos+1,list);
    }
}
