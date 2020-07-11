package problem300To400;

import java.util.*;

// 第二次解决hard，不过感觉就是mid难度，具体就是用二分去查找并维护有序数列
public class a315countSmaller {
    List<Integer> sorted = new ArrayList<>();
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>(nums.length);
        for(int i : nums){
            res.add(0);
        }
        for(int i=nums.length-1;i>=0;i--){
            res.set(i, addAndStat(nums[i]));
        }
        return res;
    }

    public int addAndStat(int i){
        if(sorted.size() == 0){
            sorted.add(i);
            return 0;
        }
        int left = 0,right = sorted.size()-1;
        while(left < right){
            if(sorted.get(left) >= i)    break;
            if(i > sorted.get(right)){
                left = right+1;
                break;
            }
            int mid = (left+right)/2;
            if(sorted.get(mid) >= i){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        if(i > sorted.get(right)){
            left = right+1;
        }
        List<Integer> rightSub = sorted.subList(left,sorted.size());
        List<Integer> leftSub = sorted.subList(0,left);
        sorted = new ArrayList<>(leftSub);
        sorted.add(i);
        sorted.addAll(rightSub);
        return left;
    }
}
