package problem1000To1100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class a1002commonChars {
    public List<String> commonChars(String[] A) {
        if(A.length == 0)   return Collections.emptyList();
        int[] arr = new int[26];
        String first = A[0];
        for (char ch : first.toCharArray()) {
            arr[ch - 'a']++;
        }
        for (int i = 1; i < A.length; i++) {
            String s = A[i];
            int[] temp = new int[26];
            for (char ch : s.toCharArray()) {
                temp[ch - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                arr[j] = Math.min(temp[j], arr[j]);
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            int num = arr[i];
            while (num > 0) {
                res.add(String.valueOf((char) (i + 'a')));
                num--;
            }
        }
        return res;
    }
}
