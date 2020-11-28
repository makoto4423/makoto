package problem100To200;

import java.util.*;

// 就是个回溯，不过加了个map，变成带缓存的回溯
@Deprecated
public class a140wordBreak {


    public List<String> wordBreak(String s, List<String> wordDict) {
        List<List<String>> res = recur(s, 0, new HashSet<>(wordDict), new HashMap<>());
        List<String> list = new ArrayList<>();
        for (List<String> temp : res) {
            list.add(String.join(" ", temp));
        }
        return list;
    }

    public List<List<String>> recur(String s, int index, Set<String> set, Map<Integer, List<List<String>>> map) {
        if (!map.containsKey(index)) {
            List<List<String>> temp = new ArrayList<>();
            if (index == s.length()) {
                temp.add(new ArrayList<>());
            }
            for (int i = index + 1; i <= s.length(); i++) {
                String a = s.substring(index, i);
                if (set.contains(a)) {
                    List<List<String>> next = recur(s, i, set, map);
                    for (List<String> list : next) {
                        List<String> t = new ArrayList<>(list);
                        t.add(0, a);
                        temp.add(t);
                    }
                }
            }
            map.put(index, temp);
        }
        return map.get(index);
    }


}
