package problem1300To1400;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class a1338minSetSize {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: arr){
            int amount =map.getOrDefault(i,0);
            amount++;
            map.put(i,amount);
        }
        int[] dp = new int[map.keySet().size()];
        int index = 0;
        for(Integer i : map.keySet()){
            dp[index++] = map.get(i);
        }
        int len = arr.length;
        Arrays.sort(dp);
        int res = 0, amount = 0;
        for(int i = dp.length-1;i>=0;i--){
            amount += dp[i];
            res++;
            if(amount >= len/2){
                return res;
            }
        }
        return -1;
    }
}
