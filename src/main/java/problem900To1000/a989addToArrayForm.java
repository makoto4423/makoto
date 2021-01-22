package problem900To1000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class a989addToArrayForm {
    public List<Integer> addToArrayForm(int[] A, int K) {
        if (K == 0) return Arrays.stream(A).boxed().collect(Collectors.toList());
        List<Integer> list = new ArrayList<>();
        while (K != 0) {
            list.add(K % 10);
            K /= 10;
        }
        int len = A.length;
        List<Integer> res = new ArrayList<>();
        int i = 0, pre = 0;
        while (i < list.size() && i < len) {
            int t = list.get(i) + A[len - i - 1] + pre;
            if (t > 9) {
                t -= 10;
                pre = 1;
            } else {
                pre = 0;
            }
            res.add(t);
            i++;
        }
        while (i < list.size()) {
            int t = list.get(i) + pre;
            if (t > 9) {
                t -= 10;
                pre = 1;
            } else {
                pre = 0;
            }
            res.add(t);
            i++;
        }
        while (i < len) {
            int t = A[len - i - 1] + pre;
            if (t > 9) {
                t -= 10;
                pre = 1;
            } else {
                pre = 0;
            }
            res.add(t);
            i++;
        }
        if (pre == 1) {
            res.add(1);
        }
        Collections.reverse(res);
        return res;
    }
}
