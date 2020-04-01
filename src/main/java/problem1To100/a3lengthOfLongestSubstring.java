package problem1To100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class a3lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int max = 0;
        StringBuilder win = new StringBuilder();
        win.append(s.charAt(0));
        int i=1;
        while(i < s.length()){
            int index = win.toString().indexOf(s.charAt(i));
            if(index >= 0){
               max = Math.max(win.length(), max);
               win = new StringBuilder(win.substring(index+1));
            }
            win.append(s.charAt(i));
            i++;
        }
        return Math.max(win.length(), max);
    }
}
