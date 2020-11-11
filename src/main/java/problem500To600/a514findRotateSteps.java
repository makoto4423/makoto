package problem500To600;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Deprecated
public class a514findRotateSteps {

    public int findRotateSteps(String ring, String key) {
        int rLen = ring.length(), kLen = key.length();
        List<Integer>[] list = new ArrayList[36];
        for (int i = 0; i < 26; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < rLen; i++) {
            list[ring.charAt(i) - 'a'].add(i);
        }
        int[][] dp = new int[kLen][rLen];
        for (int[] i : dp) {
            Arrays.fill(i, 0x3f3f3f);
        }
        for (int i : list[key.charAt(0) - 'a']) {
            dp[0][i] = Math.min(i, rLen - i) + 1;
        }
        for (int i = 1; i < kLen; i++) {
            for (int j : list[key.charAt(i) - 'a']) {
                for (int k : list[key.charAt(i - 1) - 'a']) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.min(Math.abs(j - k), rLen - Math.abs(j - k)) + 1);
                }
            }
        }
        return Arrays.stream(dp[kLen - 1]).min().orElse(0);
    }


//    String ring, key;
//
//    public int findRotateSteps(String ring, String key) {
//        this.ring = ring;
//        this.key = key;
//        return recur(0, 0);
//    }
//
//    public int recur(int start, int index) {
//        if (index == key.length()) {
//            return 0;
//        }
//        if (ring.charAt(start) == key.charAt(index)) {
//            return recur(start, index + 1) + 1;
//        }
//        int len = ring.length();
//        int left = start == 0 ? len - 1 : start - 1;
//        int distance = start < left ? len - left + start : start - left;
//        while (distance <= len / 2) {
//            if (ring.charAt(left) == key.charAt(index)) break;
//            left = left == 0 ? len - 1 : left - 1;
//            distance = start < left ? len - left + start : start - left;
//        }
//        int temp = Integer.MAX_VALUE;
//        if (ring.charAt(left) == key.charAt(index)) {
//            temp = recur(left, index + 1) + distance + 1;
//        }
//        int right = start == len - 1 ? 0 : start + 1;
//        distance = right < start ? len - start + right : right - start;
//        while (distance <= len / 2) {
//            if (ring.charAt(right) == key.charAt(index)) break;
//            right = right == len - 1 ? 0 : right + 1;
//            distance = right < start ? len - start + right : right - start;
//        }
//        if (ring.charAt(right) == key.charAt(index)) {
//            temp = Math.min(recur(right, index + 1) + distance + 1, temp);
//        }
//        return temp;
//    }
}
