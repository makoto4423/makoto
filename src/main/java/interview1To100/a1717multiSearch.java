package interview1To100;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class a1717multiSearch {
    public int[][] multiSearch(String big, String[] smalls) {
        int len = smalls.length;
        List<List<Integer>> list = new ArrayList<>();
        for (String s : smalls) {
            int index = -1;
            List<Integer> temp = new ArrayList<>();
            if (s.length() == 0) {
                list.add(temp);
                continue;
            }
            do {
                index = big.indexOf(s, index+1);
                if (index != -1) {
                    temp.add(index);
                }
            } while (index != -1);
            list.add(temp);
        }
        int[][] res = new int[len][];
        for (int i = 0; i < len; i++) {
            List<Integer> temp = list.get(i);
            int[] t = new int[temp.size()];
            for(int j=0;j<temp.size();j++){
                t[j] = temp.get(j);
            }
            res[i] = t;
        }
        return res;
    }
}
