package problem600To700;

import java.util.*;

public class a692topKFrequent {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        Map<Integer, List<String>> stat = new HashMap<>();
        for (String s : map.keySet()) {
            List<String> list = stat.getOrDefault(map.get(s), new ArrayList<>());
            list.add(s);
            stat.put(map.get(s), list);
        }
        List<Integer> list = new ArrayList<>(stat.keySet());
        Collections.sort(list);
        List<String> res = new ArrayList<>();
        int index = list.size() - 1;
        while (k > 0 && index > -1) {
            List<String> word = stat.get(list.get(index));
            Collections.sort(word);
            if (k > word.size()) {
                res.addAll(word);
                k -= word.size();
            } else {
                for (int i = 0; k > 0; i++, k--) {
                    res.add(word.get(i));
                }
            }
            index--;
        }
        return res;
    }
}
