package problem400To500;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 数独？
public class a423originalDigits {
    public String originalDigits(String s) {
        int[] stat = new int[26];
        for (char ch : s.toCharArray()) {
            stat[ch - 'a']++;
        }
        List<Integer> list = new ArrayList<>();
        while (0 < stat['z' - 'a']
                && stat['e' - 'a'] > 0
                && stat['r' - 'a'] > 0
                && stat['o' - 'a'] > 0) {
            list.add(0);
            stat['z' - 'a']--;
            stat['e' - 'a']--;
            stat['r' - 'a']--;
            stat['o' - 'a']--;
        }
        while (0 < stat['w' - 'a'] && stat['t' - 'a'] > 0 && stat['o' - 'a'] > 0) {
            list.add(2);
            stat['t' - 'a']--;
            stat['w' - 'a']--;
            stat['o' - 'a']--;
        }
        while (0 < stat['u' - 'a'] && stat['f' - 'a'] > 0 && stat['o' - 'a'] > 0
                && stat['r' - 'a'] > 0) {
            list.add(4);
            stat['f' - 'a']--;
            stat['o' - 'a']--;
            stat['u' - 'a']--;
            stat['r' - 'a']--;
        }
        while (0 < stat['x' - 'a']
                && stat['s' - 'a'] > 0 && stat['i' - 'a'] > 0) {
            list.add(6);
            stat['s' - 'a']--;
            stat['i' - 'a']--;
            stat['x' - 'a']--;
        }
        while (0 < stat['o' - 'a']
                && stat['n' - 'a'] > 0 && stat['e' - 'a'] > 0) {
            list.add(1);
            stat['o' - 'a']--;
            stat['n' - 'a']--;
            stat['e' - 'a']--;
        }
        while (0 < stat['r' - 'a']
                && stat['t' - 'a'] > 0 && stat['h' - 'a'] > 0
                && stat['e' - 'a'] > 1) {
            list.add(3);
            stat['t' - 'a']--;
            stat['h' - 'a']--;
            stat['r' - 'a']--;
            stat['e' - 'a']--;
            stat['e' - 'a']--;
        }
        while (0 < stat['s' - 'a']
                && stat['e' - 'a'] > 1 && stat['v' - 'a'] > 0
                && stat['n' - 'a'] > 0) {
            list.add(7);
            stat['s' - 'a']--;
            stat['e' - 'a']--;
            stat['v' - 'a']--;
            stat['e' - 'a']--;
            stat['n' - 'a']--;
        }
        while (0 < stat['v' - 'a'] && stat['f' - 'a'] > 0
                && stat['i' - 'a'] > 0 && stat['e' - 'a'] > 0) {
            list.add(5);
            stat['f' - 'a']--;
            stat['i' - 'a']--;
            stat['v' - 'a']--;
            stat['e' - 'a']--;
        }
        while (0 < stat['e' - 'a'] && stat['i' - 'a'] > 0
                && stat['g' - 'a'] > 0 && stat['h' - 'a'] > 0
                && stat['t' - 'a'] > 0) {
            list.add(8);
            stat['e' - 'a']--;
            stat['i' - 'a']--;
            stat['g' - 'a']--;
            stat['h' - 'a']--;
            stat['t' - 'a']--;
        }
        while (0 < stat['n' - 'a']) {
            list.add(9);
            stat['n' - 'a']--;
            stat['i' - 'a']--;
            stat['n' - 'a']--;
            stat['e' - 'a']--;
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int i : list) {
            sb.append(i);
        }
        return sb.toString();
    }
}
