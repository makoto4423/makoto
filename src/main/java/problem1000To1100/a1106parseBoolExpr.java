package problem1000To1100;

import java.util.Stack;

public class a1106parseBoolExpr {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> op = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '!' || ch == '&' || ch == '|') {
                op.push(ch);
                stack.push('(');
                i++;
            } else if (ch == ')') {
                Character o = op.pop();
                boolean b = stack.pop() == 't';
                while (stack.peek() != '(') {
                    boolean c = stack.pop() == 't';
                    if (o == '&') {
                        b &= c;
                    } else {
                        b |= c;
                    }
                }
                if (o == '!') b = !b;
                stack.pop();
                stack.push(b ? 't' : 'f');
            } else if (ch != ',') {
                stack.push(ch);
            }
        }
        return stack.pop() == 't';
    }
}
