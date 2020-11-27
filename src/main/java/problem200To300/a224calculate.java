package problem200To300;

import java.util.*;

public class a224calculate {
    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        List<String> queue = new ArrayList<>();
        int pre = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '(' || c == ')'){
                queue.add(c+"");
            }else if (c == '+' || c == '-'){
                queue.add(pre+"");
                queue.add(c+"");
                pre = 0;
            }else {
                pre *= 10;
                pre += c-'0';
                if(i == s.length()-1) queue.add(pre+"");
            }
        }
        String p = queue.get(0);
        if(p.equals("(")){
            queue.remove(queue.size()-1);
            queue.remove(0);
            p = queue.get(0);
        }

        return pre;
    }
}
