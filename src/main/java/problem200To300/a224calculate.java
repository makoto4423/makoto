package problem200To300;

import java.util.*;

public class a224calculate {
    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();
        char op = ' ';
        int cur = 0;
        for (char ch : s.toCharArray()) {
            if (ch <= '9' && ch >= '0') {
                cur = cur * 10 + (ch - '0');
            } else if (ch == '+' || ch == '-') {
                if (op == ' ') {
                    numStack.add(cur);
                } else {
                    int pre = numStack.pop();
                    if (op == '+') {
                        cur += pre;
                    } else {
                        cur = pre - cur;
                    }
                    numStack.push(cur);
                }
                cur = 0;
                op = ch;
            } else if (ch == '(') {
                if (op != ' ') {
                    opStack.push(op);
                }
                opStack.push(ch);
                op = ' ';
            } else {
                if (op == '+') {
                    int pre = numStack.pop();
                    cur += pre;
                } else if (op == '-') {
                    int pre = numStack.pop();
                    cur = pre - cur;
                }
                opStack.pop();
                if (!opStack.isEmpty() && opStack.peek() != '(') {
                    int pre = numStack.pop();
                    op = opStack.pop();
                    if (op == '+') {
                        cur += pre;
                    } else {
                        cur = pre - cur;
                    }
                }
                op = ' ';
            }
        }
        if (!numStack.isEmpty()) {
            int pre = numStack.pop();
            if (op == '+') {
                cur += pre;
            } else {
                cur = pre - cur;
            }
        }
        return cur;
    }
}
