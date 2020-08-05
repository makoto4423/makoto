package problem100To200;

import java.util.*;

// 题目的定义都快把答案写出来了，通过栈
public class a150evalRPN {

    public int evalRPN(String[] tokens) {
        Set<String> set = new HashSet<>();
        set.add("+");set.add("-");set.add("*");set.add("/");
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (set.contains(token)) {
                int a = stack.pop();
                int b = stack.pop();
                int res;
                if (token.equals("+")){
                    res = a+b;
                }else if(token.equals("-")){
                    res = b-a;
                }else if(token.equals("*")){
                    res = a*b;
                }else{
                    res = b/a;
                }
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
