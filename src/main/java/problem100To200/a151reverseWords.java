package problem100To200;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class a151reverseWords {
    public String reverseWords(String s) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != ' '){
                sb.append(s.charAt(i));
            }else{
                if(sb.length() != 0){
                    list.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
        }
        if(sb.length() != 0){
            list.add(sb.toString());
        }
        if(list.size() == 0) return "";
        Collections.reverse(list);
        sb = new StringBuilder();
        for(String s1:list){
            sb.append(" ").append(s1);
        }
        return sb.toString().substring(1,sb.length());
    }
}
