package match.a1025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckArithmeticSubarrays {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            res.add(check(Arrays.copyOfRange(nums, l[i], r[i]+1)));
        }
        return res;
    }

    public boolean check(int[] num) {
        if (num.length < 3) return true;
        Arrays.sort(num);
        int dif = num[1] - num[0];
        for (int i = 2; i < num.length; i++) {
            if (dif != num[i] - num[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
