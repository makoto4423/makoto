package problem800To900;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class a842splitIntoFibonacci {
    public List<Integer> splitIntoFibonacci(String S) {
        int i = 1;
        int len = S.length();
        for (; i <= len / 2 && i < 11; i++) {
            String a = S.substring(0, i);
            if (a.charAt(0) == '0' && a.length() != 1) {
                break;
            }
            if (a.length() == 10 && a.compareTo(Integer.MAX_VALUE + "") > 0) break;
            for (int j = i + 1; j < len && j - i < 11; j++) {
                String b = S.substring(i, j);
                if (b.charAt(0) == '0' && b.length() != 1) break;
                if (b.length() == 10 && b.compareTo(Integer.MAX_VALUE + "") > 0) break;
                List<Integer> t = findFibonacci(S, Integer.parseInt(a), Integer.parseInt(b), j + 1);
                if (t.size() > 2) return t;
            }
        }
        return Collections.emptyList();
    }

    public List<Integer> findFibonacci(String s, int a, int b, int j) {
        List<Integer> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        int temp = a + b;
        String tar = temp + "";
        while (s.indexOf(tar, j - 1) == j - 1) {
            j += tar.length();
            list.add(temp);
            a = b;
            b = temp;
            temp = a + b;
            tar = temp + "";
        }
        if (j == s.length() + 1) {
            return list;
        } else {
            return Collections.emptyList();
        }
    }
}
