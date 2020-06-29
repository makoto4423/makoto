package problem1To100;

import java.util.HashMap;
import java.util.Map;

public class a13romanToInt {
    public int romanToInt(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int len = s.length();
        for (int i = len - 1; i >= 0; i--) {
            if (i > 0) {
                if (s.charAt(i) == 'V' || s.charAt(i) == 'X') {
                    if (s.charAt(i - 1) == 'I') {
                        res += map.get(s.charAt(i)) - 1;
                        i--;
                    } else {
                        res += map.get(s.charAt(i));
                    }
                } else if (s.charAt(i) == 'L' || s.charAt(i) == 'C') {
                    if (s.charAt(i - 1) == 'X') {
                        res += map.get(s.charAt(i)) - 10;
                        i--;
                    } else {
                        res += map.get(s.charAt(i));
                    }
                } else if (s.charAt(i) == 'D' || s.charAt(i) == 'M') {
                    if (s.charAt(i - 1) == 'C') {
                        res += map.get(s.charAt(i)) - 100;
                        i--;
                    } else {
                        res += map.get(s.charAt(i));
                    }
                } else {
                    res += map.get(s.charAt(i));
                }
            } else {
                res += map.get(s.charAt(i));
            }
        }
        return res;
    }
}
