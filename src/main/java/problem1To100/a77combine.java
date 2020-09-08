package problem1To100;

import java.util.ArrayList;
import java.util.List;

public class a77combine {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        if(n == 0 || k == 0)    return res;
        recur(0,n,k,new ArrayList<>());
        return res;
    }

    public void recur(int m, int n, int k, List<Integer> list){
        if(list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=m+1;i<=n;i++){
            list.add(i);
            recur(i,n,k,list);
            list.remove(list.size()-1);
        }
    }
}
