package problem1200To1300;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class a1208equalSubstring {
    public int equalSubstring(String s, String t, int maxCost) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(Math.abs(s.charAt(i) - t.charAt(i)));
        }
        int max = 0, l = 0, r = 0, cur = 0;
        while (r < list.size()) {
            cur += list.get(r++);
            while (cur > maxCost) {
                cur -= list.get(l++);
            }
            max = Math.max(max, r - l);
        }
        return max;
    }
}
