package problem200To300;

import java.util.ArrayList;
import java.util.List;

// 摩尔投票
@Deprecated
public class a229majorityElement {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1=Integer.MAX_VALUE,candidate2 = Integer.MAX_VALUE;
        int cnt1=0,cnt2=0;
        for(int num : nums){
            if(num == candidate1){
                cnt1++;
            }else if(num == candidate2){
                cnt2++;
            }else if(cnt1 == 0){
                candidate1 = num;cnt1++;
            }else if(cnt2 == 0){
                candidate2 = num;cnt2++;
            }else{
                cnt1--;cnt2--;
            }
        }
        cnt1=0;cnt2 = 0;
        for(int num : nums){
            if(num == candidate1){
                cnt1++;
            }else if(num == candidate2){
                cnt2++;
            }
        }
        List<Integer> res = new ArrayList<>();
        if(cnt1 > nums.length/3){
            res.add(candidate1);
        }
        if(cnt2 > nums.length/3){
            res.add(candidate2);
        }
        return res;
    }
}
