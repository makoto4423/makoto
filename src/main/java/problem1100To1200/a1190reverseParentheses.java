package problem1100To1200;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class a1190reverseParentheses {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb;
        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                sb = new StringBuilder();
                while (!stack.isEmpty()) {
                    char c = stack.pop();
                    if (c == '(') {
                        break;
                    } else {
                        sb.append(c);
                    }
                }
                for (char c : sb.toString().toCharArray()) {
                    stack.push(c);
                }
            } else {
                stack.push(ch);
            }
        }
        sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
