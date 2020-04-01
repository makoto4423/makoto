package problem200To300;

import java.util.HashMap;
import java.util.Map;

public class a205isIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> tmap = new HashMap<>();
        for (int i = 0, m = 0, n=0; i < s.length(); i++) {
            if (!smap.containsKey(s.charAt(i))) {
                smap.put(s.charAt(i), m);
                m++;
            }
            if(!tmap.containsKey(t.charAt(i))){
                tmap.put(t.charAt(i), n);
                n++;
            }
        }
        StringBuilder ssb = new StringBuilder();
        StringBuilder tsb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            ssb.append(smap.get(s.charAt(i)));
            tsb.append(tmap.get(t.charAt(i)));
        }
        return ssb.toString().equals(tsb.toString());
    }
}
