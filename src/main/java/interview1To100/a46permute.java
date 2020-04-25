package interview1To100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class a46permute {
    int len;
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        len = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int num : nums){
            list.add(num);
        }
        recur(list,0);
        return res;
    }

    public void recur(List<Integer> list, int pos){
        if(pos == len){
            res.add(new ArrayList<>(list));
        }
        for(int i=pos; i<len; i++){
            Collections.swap(list,i,pos);
            recur(list,pos+1);
            Collections.swap(list,i,pos);
        }
    }

}
