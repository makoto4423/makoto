package problem400To500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a438findAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length()<p.length())   return new ArrayList<>();
        int[] stat = new int[26];
        for(char ch : p.toCharArray()){
            stat[ch-'a']++;
        }
        int[] cp = Arrays.copyOf(stat,stat.length);
        for(int i=0;i<p.length();i++){
            cp[s.charAt(i)-'a']--;
        }
        List<Integer> res = new ArrayList<>();
        if(check(cp))   res.add(0);
        for(int i=1;i<=s.length()-p.length();i++){
            cp[s.charAt(i-1)-'a']++;
            cp[s.charAt(i+p.length()-1)-'a']--;
            if(check(cp))   res.add(i);
        }
        return res;
    }

    public boolean check(int[] ch){
        for(int num : ch){
            if(num != 0)    return false;
        }
        return true;
    }
}
