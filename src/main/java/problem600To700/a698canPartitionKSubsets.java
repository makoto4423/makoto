package problem600To700;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Deprecated
public class a698canPartitionKSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int[] arr = new int[k];
        List<Integer> list = new ArrayList<>();
        int sum =0;
        for(int num : nums){
            sum += num;
            list.add(num);
        }
        if(sum%k!=0)    return false;
        int val = helper(list,sum/k, 0);
        return val == k;
    }

    public int helper(List<Integer> list,int tar, int cnt){
        if(list.size() == 0) return cnt;
        for(int i=0; i<list.size(); i++){
            for(int j=i+1; j<list.size(); j++){
                if(list.get(i)+list.get(j) == tar){
                    cnt++;
                    List<Integer> mid = new ArrayList<>(list);
                    int finalI = i;
                    int finalJ = j;
                    mid.removeIf((a)-> a == finalI);
                    mid.removeIf((a)-> a== finalJ);
                    return  helper(mid, tar, cnt);
                }
            }
        }
        return cnt;
    }
}
