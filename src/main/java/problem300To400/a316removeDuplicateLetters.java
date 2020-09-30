package problem300To400;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

// 又不要求连续子字符串，分治啥。。。
@Deprecated
public class a316removeDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!set.contains(ch)){
                while (!stack.isEmpty()){
                    Character c = stack.peek();
                    if(c>ch && s.indexOf(c,i) >= 0){
                        stack.pop();
                        set.remove(c);
                    }else{
                        break;
                    }
                }
                stack.push(ch);
                set.add(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
