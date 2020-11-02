package problem300To400;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class a349intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums1){
            set.add(i);
        }
        List<Integer> list = new ArrayList<>();
        for(int i : nums2){
            if(set.contains(i)){
                set.remove(i);
                list.add(i);
            }
        }
        int[] res = new int[list.size()];
        for(int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
