package problem1To100;

import java.util.Arrays;

public class a14longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)    return "";
        Arrays.sort(strs);
        String pre = strs[0];
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<pre.length(); i++){
            sb.append(pre.charAt(i));
            for(String str: strs){
                if(str.indexOf(sb.toString()) == 0) continue;
                sb.deleteCharAt(i);
                return sb.toString();
            }
        }
        return sb.toString();
    }
}
