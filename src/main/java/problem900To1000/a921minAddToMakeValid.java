package problem900To1000;

import java.util.Stack;

public class a921minAddToMakeValid {
    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();
        for(char ch : S.toCharArray()){
            if(!stack.isEmpty() && ch == ')' && stack.peek() == '('){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        return stack.size();
    }
}
