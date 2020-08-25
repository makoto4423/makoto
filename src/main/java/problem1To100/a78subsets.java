package problem1To100;

import java.util.ArrayList;
import java.util.List;

public class a78subsets {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        help(0,nums,new ArrayList<>());
        return res;
    }

    public void help(int pos, int[] num, List<Integer> list){
        res.add(new ArrayList<>(list));
        for(int i=pos;i<num.length;i++){
            list.add(num[i]);
            help(i+1,num,list);
            list.remove(list.size()-1);
        }
    }
}
