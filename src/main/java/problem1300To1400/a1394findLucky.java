package problem1300To1400;

import java.util.HashMap;
import java.util.Map;

public class a1394findLucky {
    public int findLucky(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : arr){
            int cnt = 0;
            if(map.containsKey(i)){
                cnt = map.get(i);
            }
            map.put(i,++cnt);
        }
        int res = -1;
        for(Integer i : map.keySet()){
            if(i.equals(map.get(i))){
                res = Math.max(i,res);
            }
        }
        return res;
    }
}
