package problem1200To1300;

import java.util.Stack;

public class a1221balancedStringSplit {
    public int balancedStringSplit(String s) {
        int res = 0;
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(ch);
            } else {
                Character character = stack.peek();
                if (ch + character == 158) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        res++;
                    }
                } else {
                    stack.push(ch);
                }
            }
        }
        return res;
    }
}
