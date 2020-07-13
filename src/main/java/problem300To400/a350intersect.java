package problem300To400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a350intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> m1 = new HashMap<>();
        for(int i : nums1){
            m1.put(i, m1.getOrDefault(i,0)+1);
        }
        for(int i : nums2){
            if(m1.containsKey(i) && m1.get(i) != 0){
                res.add(i);
                m1.put(i,m1.get(i)-1);
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
