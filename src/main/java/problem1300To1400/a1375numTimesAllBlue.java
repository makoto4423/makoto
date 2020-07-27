package problem1300To1400;

import java.util.HashSet;
import java.util.Set;

public class a1375numTimesAllBlue {
    public int numTimesAllBlue(int[] light) {
        int[] init = new int[light.length];
        int right = 0, res = 0, cnt = -1;
        for (int i = 0; i < light.length; i++) {
            init[light[i] - 1] = 1;
            if (light[i] - 1 == right) {
                res++;
                right++;
                init[light[i] - 1] = 2;
                for (int j = light[i]; j < light.length; j++) {
                    if (init[j] == 1) {
                        right++;
                        init[j] = 2;
                    }
                }
            } else {
                if (cnt == 0) {
                    res++;
                } else if (cnt == -1) {
                    right = light[i] - 1;
                    cnt = light[i] - 1;
                } else {
                    cnt--;
                }
            }
        }
        if(cnt == 0){
            res++;
        }
        return res;
    }
}
