package problem100To200;

import java.util.ArrayList;
import java.util.List;

public class a127ladderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<Integer> list = new ArrayList<>();
        int len = wordList.size();
        for (int i = 0; i < len; i++) {
            String s = wordList.get(i);
            if (s.equals(endWord)) {
                list.add(i);
            }
        }
        if (list.size() == 0) return 0;
        int[] arr = new int[len];
        arr[list.get(0)] = 1;
        while (list.size() != 0) {
            List<Integer> child = new ArrayList<>();
            for (int i : list) {
                for (int j = 0; j < len; j++) {
                    if (i == j || arr[j] != 0) continue;
                    String a = wordList.get(i), b = wordList.get(j);
                    if (diff(a, b)) {
                        arr[j] = arr[i] + 1;
                        child.add(j);
                    }
                }
            }
            list = child;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (arr[i] == 0) continue;
            String a = wordList.get(i);
            if (diff(beginWord, a)) {
                res = Math.min(res, arr[i] + 1);
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public boolean diff(String a, String b) {
        int len = a.length();
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                res++;
            }
        }
        return res == 1;
    }
}
