package problem700To800;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class a767reorganizeString {
    public String reorganizeString(String S) {
        int len = S.length();
        int[] arr = new int[26];
        for (char ch : S.toCharArray()) {
            arr[ch - 'a']++;
            if (arr[ch - 'a'] > (len + 1) / 2) {
                return "";
            }
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> -o[0]));
        for (int i = 0; i < 26; i++) {
            if(arr[i] != 0){
                queue.add(new int[]{arr[i], i});
            }
        }
        int pre = -1;
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int[] cnt = queue.poll();
            if (cnt[1] == pre) {
                int[] ano = queue.poll();
                queue.add(cnt);
                cnt = ano;
            }
            sb.append((char) (cnt[1] + 'a'));
            pre = cnt[1];
            cnt[0]--;
            if (cnt[0] != 0) {
                queue.add(cnt);
            }
        }
        return sb.toString();
    }
}
