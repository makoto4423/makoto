package problem700To800;

import java.util.HashSet;
import java.util.Set;

public class a822flipgame {
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> out = new HashSet<>();
        for(int i=0;i<fronts.length;i++){
            if(fronts[i] == backs[i]){
                out.add(fronts[i]);
                set.remove(fronts[i]);
            }else{
                if(!out.contains(fronts[i])){
                    set.add(fronts[i]);
                }
                if(!out.contains(backs[i])){
                    set.add(backs[i]);
                }
            }
        }
        if(set.size() == 0) return 0;
        int res = Integer.MAX_VALUE;
        for(Integer i : set){
            res = Math.min(res,i);
        }
        return res;

    }
}
