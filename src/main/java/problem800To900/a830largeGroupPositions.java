package problem800To900;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a830largeGroupPositions {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < s.length() - 2; i++) {
            int j = i + 1;
            for (; j < s.length(); j++) {
                if (s.charAt(i) != s.charAt(j)) break;
            }
            j--;
            if (j - i > 1) {
                res.add(Arrays.asList(i, j));
            }
            i = j;
        }
        return res;
    }
}
