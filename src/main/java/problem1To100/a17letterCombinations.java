package problem1To100;

import java.util.*;

public class a17letterCombinations {
    Map<Character, char[]> map;
    List<String> res;
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)    return new ArrayList<>();
        map = new HashMap<>();
        res = new ArrayList<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        help(digits,new StringBuilder());
        return res;
    }

    public void help(String digits, StringBuilder sb){
        if(sb.length() == digits.length()){
            res.add(sb.toString());
        }else{
            char ch = digits.charAt(sb.length());
            char[] arr = map.get(ch);
            for(char c : arr){
                sb.append(c);
                help(digits,sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
