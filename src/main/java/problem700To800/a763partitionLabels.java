package problem700To800;

import java.util.ArrayList;
import java.util.List;

public class a763partitionLabels {
    public List<Integer> partitionLabels(String S) {
        int[] arr = new int[26];
        int len = S.length();
        for (int i = 0; i < len; i++) {
            arr[S.charAt(i) - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        if (len == 0) return res;
        int left = 0, right = arr[S.charAt(left) - 'a'];
        while (left != len) {
            for (int i = left + 1; i <= right; i++) {
                right = Math.max(right, arr[S.charAt(i) - 'a']);
            }
            res.add(right - left + 1);
            left = right + 1;
            if (left != len) {
                right = arr[S.charAt(left) - 'a'];
            }
        }
        return res;
    }
}
