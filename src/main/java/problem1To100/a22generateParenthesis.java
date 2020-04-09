package problem1To100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class a22generateParenthesis {
    public List<String> generateParenthesis(int n) {
        if(n < 1) return new ArrayList<>();
        Set<String> set = new HashSet<>();
        set.add("()");
        for(int i=1; i<n; i++){
            Set<String> ss = new HashSet<>();
            for(String s: set){
                for(int j=0; j<s.length(); j++){
                    ss.add(s.substring(0,j)+"()"+s.substring(j));
                }
            }
            set = ss;
        }
        return new ArrayList<>(set);
    }


//    官方答案，耗时比我的答案少一半
//    List[] cache = new ArrayList[100];
//    public List<String> generateParenthesis(int n) {
//        return help(n);
//    }
//
//    public List<String> help(int n){
//        if(cache[n] != null){
//            return cache[n];
//        }
//        List<String> list = new ArrayList<>();
//        if(n == 0){
//            list.add("");
//        }else{
//            for(int i=0; i<n; i++){
//                for(String left : help(i)){
//                    for(String right : help(n-i-1)){
//                        list.add("("+left+")"+right);
//                    }
//                }
//            }
//            cache[n] = list;
//        }
//        return list;
//    }
}
