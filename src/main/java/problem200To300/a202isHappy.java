package problem200To300;

import java.util.HashSet;
import java.util.Set;

public class a202isHappy {
    public boolean isHappy(int n) {
        if(n==0)    return false;
        Set<Integer> set = new HashSet<>();
        while(n != 1){
            int m = n,a=0;
            while(m!=0){
                a += (m%10)*(m%10);
                m /= 10;
            }
            if(set.contains(a)) return false;
            set.add(a);
            n = a;
        }
        return true;
    }
}
