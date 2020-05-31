package problem600To700;

import java.util.HashSet;
import java.util.Set;

public class a645findErrorNums {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int f = 0,sum=0;
        for(int i: nums){
            if(set.contains(i)){
                f = i;
            }else{
                set.add(i);
            }
            sum += i;
        }
        int len = nums.length;
        int right = (len*(1+len)/2)-sum+f;
        return new int[]{f,right};
    }
}
