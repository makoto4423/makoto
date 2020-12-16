package problem1200To1300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
// 还是不会写。。。
@Deprecated
public class a1262maxSumDivThree {
    public int maxSumDivThree(int[] nums) {
        int res = 0;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<4;i++){
            list.add(new ArrayList<>());
        }
        for(int i=nums.length-1;i>=0;i--){
            int v  = nums[i];
            int a = v%3;
            if(a==0){
                res += v;
            }else{
                list.get(a).add(i);
            }
        }
        List<Integer> l1 = list.get(1);
        List<Integer> l2 = list.get(2);
        Collections.sort(l1);
        Collections.sort(l2);
        while (l1.size() > 2){
            res += l1.get(l1.size()-1)+l1.get(l1.size()-2)+l1.get(l1.size()-3);
            l1.remove(l1.size()-1);
            l1.remove(l1.size()-1);
            l1.remove(l1.size()-1);
        }
        while (l2.size() > 2){
            res += l2.get(l2.size()-1)+l2.get(l2.size()-2)+l2.get(l2.size()-3);
            l2.remove(l2.size()-1);
            l2.remove(l2.size()-1);
            l2.remove(l2.size()-1);
        }
        return res;
    }
}
