package problem900To1000;

import java.util.HashMap;
import java.util.Map;

public class a992subarraysWithKDistinct {
    public int subarraysWithKDistinct(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0, n = A.length, res = 0;
        while (right < n) {
            if(!map.containsKey(A[right]) && map.keySet().size() >= K){
                while (map.keySet().size() >= K) {
                    Integer i = map.get(A[left]);
                    i--;
                    if (i == 0) {
                        map.remove(A[left]);
                    } else {
                        map.put(A[left], i);
                    }
                    left++;
                }
            }
            Integer i = map.getOrDefault(A[right], 0);
            map.put(A[right], i + 1);
            if (map.keySet().size() == K) {
                if(map.get(A[left]) > 1){
                    int temp = left;
                    Map<Integer,Integer> mt = new HashMap<>(map);
                    while (mt.getOrDefault(A[temp],0) > 1){
                        res++;
                        i = mt.get(A[temp]);
                        i--;
                        mt.put(A[temp],i);
                        temp++;
                    }
                }
                res++;
            }
            right++;
        }
        return res;
    }
}
