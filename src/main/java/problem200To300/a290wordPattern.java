package problem200To300;

import java.util.HashSet;
import java.util.Set;

public class a290wordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = new String[26];
        Set<String> set = new HashSet<>();
        String[] ss = s.split(" ");
        if (pattern.length() != ss.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            int j = pattern.charAt(i) - 'a';
            String a = arr[j];
            if (a == null) {
                arr[j] = ss[i];
                if (set.contains(ss[i])) return false;
                set.add(ss[i]);
            } else {
                if (!a.equals(ss[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
