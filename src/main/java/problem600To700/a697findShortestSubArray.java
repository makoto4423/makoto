package problem600To700;

import java.util.*;

public class a697findShortestSubArray {

    public int findShortestSubArray(int[] nums) {
        int max = 0,cnt=1;
        List<Integer> same = new ArrayList<>();
        int[] stat = new int[nums.length];
        System.arraycopy(nums,0,stat,0,nums.length);
        Arrays.sort(stat);
        for(int i=0;i<stat.length-1;i++){
            if(stat[i] == stat[i+1]){
                cnt++;
                if(cnt > max){
                    max = cnt;
                    same = new ArrayList<>();
                    same.add(stat[i]);
                }else if(cnt == max){
                     same.add(stat[i]);
                }
            }else{
                cnt = 1;
            }
        }
        if(same.size() == 0)    return 1;
        max = Integer.MAX_VALUE;
        for(int m : same){
            int start = -1,end=-1;
            for(int i=0;i<nums.length;i++){
                if(nums[i] == m){
                    start = i;
                    break;
                }
            }
            for(int j=nums.length-1;j>=0;j--){
                if(nums[j] == m){
                    end = j;
                    break;
                }
            }
            max = Math.min(max,end-start+1);
        }
        return max;

    }

}
