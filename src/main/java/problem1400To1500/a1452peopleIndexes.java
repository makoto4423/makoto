package problem1400To1500;

import java.util.*;

public class a1452peopleIndexes {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        int index = 0;
        Map<String, Integer> map = new HashMap<>();
        for (List<String> favor : favoriteCompanies) {
            for (String s : favor) {
                if (!map.containsKey(s)) {
                    map.put(s, index++);
                }
            }
        }
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            List<Integer> list = new ArrayList<>();
            for (String s : favoriteCompanies.get(i)) {
                list.add(map.get(s));
            }
            Collections.sort(list);
            indexMap.put(i, list);
        }
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        loop:
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            List<Integer> list = indexMap.get(i);
            Iterator<Integer> iterator = set.iterator();
            while (iterator.hasNext()) {
                Integer j = iterator.next();
                List<Integer> temp = indexMap.get(j);
                int m = 0, n = 0;
                while (m < list.size() && n < temp.size()) {
                    if (list.get(m).equals(temp.get(n))) {
                        m++;
                        n++;
                    } else if (list.get(m) > temp.get(n)) {
                        n++;
                    } else {
                        break;
                    }
                }
                if (m == list.size()) continue loop;
                m = 0;
                n = 0;
                while (m < list.size() && n < temp.size()) {
                    if (list.get(m).equals(temp.get(n))) {
                        m++;
                        n++;
                    } else if (temp.get(n) > list.get(m)) {
                        m++;
                    } else {
                        break;
                    }
                }
                if (n == temp.size()) {
                    iterator.remove();
                    res.remove(j);
                }
            }
            set.add(i);
            res.add(i);
        }
        return res;
    }
}
