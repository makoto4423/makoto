package problem500To600;

import java.util.HashMap;
import java.util.Map;

public class a560subarraySum {

    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int pre = 0, cnt = 0;
        for(int i: nums){
            pre += i;
            if(map.containsKey(pre-k)){
                cnt += map.get(pre-k);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return cnt;
        // 暴力竟然也能解决。。。
//        int amount = 0;
//        for(int i=0;i<nums.length; i++){
//            int cnt = nums[i];
//            if(cnt == k)    amount++;
//            for(int j=i+1;j<nums.length;j++){
//                cnt+=nums[j];
//                if(cnt == k) amount++;
//            }
//        }
//        return amount;
    }

}
