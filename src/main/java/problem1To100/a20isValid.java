package problem1To100;

import java.util.Stack;

public class a20isValid {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char c = stack.pop();
                if(ch == ')' && c != '('){
                    return false;
                }else if(ch == '}' && c != '{'){
                    return false;
                }else if(ch == ']' && c != '['){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
