package problem1500To1600;

import java.util.HashSet;
import java.util.Set;

@Deprecated
public class a1546maxNonOverlapping {

    public int maxNonOverlapping(int[] nums, int target) {
        int cur = 0,res = 0;
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for(int num : nums){
            cur += num;
            if(set.contains(cur-target)){
                set.clear();
                set.add(0);
                cur = 0;
                res++;
            }else{
                set.add(cur);
            }
        }
        return res;
    }
}
