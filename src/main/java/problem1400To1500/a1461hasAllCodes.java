package problem1400To1500;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class a1461hasAllCodes {
    public boolean hasAllCodes(String s, int k) {
        Set<Integer> set = new HashSet<>();
        int tar = (int) (Math.pow(2,k));
        for(int i=0;i<=s.length()-k;i++){
            String a = s.substring(i,i+k);
            int v = Integer.parseInt(a,2);
            if(v < tar){
                set.add(v);
            }
        }
        return set.size() == tar;
    }
}
