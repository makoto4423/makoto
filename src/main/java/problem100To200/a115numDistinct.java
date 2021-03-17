package problem100To200;

import java.util.HashMap;
import java.util.Map;


// 题解用的是动态规划
// 自己写用的是前缀记忆
public class a115numDistinct {

    public int numDistinct(String s, String t) {
        Map<String, Integer> stat = new HashMap<>();
        for (char ch : s.toCharArray()) {
            Map<String, Integer> m = new HashMap<>(stat);
            for (String k : stat.keySet()) {
                if (t.startsWith(k + ch)) {
                    m.put(k + ch, stat.get(k) + stat.getOrDefault(k + ch, 0));
                }
            }
            if (t.startsWith(ch + "")) {
                m.put(ch + "", stat.getOrDefault(ch + "", 0) + 1);
            }
            stat = m;
        }
        return stat.getOrDefault(t,0);
    }
}
