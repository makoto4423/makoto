package problem1400To1500;

import java.util.ArrayList;
import java.util.List;
// 六一出这道题目，真欢乐
public class a1431kidsWithCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for(int i : candies){
            max = Math.max(i,max);
        }
        List<Boolean> res = new ArrayList<>();
        for(int i : candies){
            if(i+extraCandies>=max){
                res.add(true);
            }else{
                res.add(false);
            }
        }
        return res;
    }
}
