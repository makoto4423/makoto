package match.a0920;

import java.util.HashSet;
import java.util.Set;

public class a5520maxUniqueSplit {
    int res;

    public int maxUniqueSplit(String s) {
        res = 0;
        recur(0, new HashSet<>(), s);
        return res;
    }

    public void recur(int index, Set<String> set, String s) {
        if (index == s.length()) {
            res = Math.max(res, set.size());
            return;
        }
        for (int j = index + 1; j <= s.length(); j++) {
            String a = s.substring(index, j);
            if (!set.contains(a)) {
                set.add(a);
                recur(j, set, s);
                set.remove(a);
            }
        }
    }
}
