package problem400To500;

import java.util.*;

public class a451frequencySort {
    public String frequencySort(String s) {
        Map<Character, Frequency> map = new HashMap<>();
        List<Frequency> list = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            if (!map.containsKey(ch)) {
                Frequency f = new Frequency(ch, 1);
                map.put(ch, f);
                list.add(f);
            } else {
                map.get(ch).freq++;
            }
        }
        list.sort(Comparator.comparingInt(a -> -a.freq));
        StringBuilder sb = new StringBuilder();
        for (Frequency f : list) {
            while (f.freq != 0) {
                sb.append(f.ch);
                f.freq--;
            }
        }
        return sb.toString();
    }

    static class Frequency {

        char ch;
        int freq;

        public Frequency(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }
}
