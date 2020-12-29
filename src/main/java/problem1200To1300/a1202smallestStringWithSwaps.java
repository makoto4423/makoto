package problem1200To1300;

import java.util.*;

public class a1202smallestStringWithSwaps {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int len = s.length();
        Union union = new Union(len);
        for (List<Integer> pair : pairs) {
            union.add(pair.get(0), pair.get(1));
        }
        Map<Integer, Queue<Character>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            Queue<Character> queue = map.getOrDefault(union.find(i), new PriorityQueue<>(Character::compareTo));
            queue.add(s.charAt(i));
            map.put(union.find(i), queue);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(map.get(union.find(i)).poll());
        }
        return sb.toString();
    }

    static class Union {
        int[] arr;

        public Union(int len) {
            arr = new int[len];
            for (int i = 0; i < len; i++) {
                arr[i] = i;
            }
        }

        public int find(int m) {
            if (arr[m] != m) {
                arr[m] = find(arr[m]);
            }
            return arr[m];
        }

        public void add(int m, int n) {
            arr[find(m)] = find(n);
        }
    }
}
