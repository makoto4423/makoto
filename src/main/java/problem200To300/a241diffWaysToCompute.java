package problem200To300;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// 大概想到了解法，却总是离答案隔着一层纱
@Deprecated
public class a241diffWaysToCompute {
    public List<Integer> diffWaysToCompute(String input) {
        int index = 0;
        while (index < input.length() && !isOperation(input.charAt(index))) {
            index++;
        }
        if (index == input.length()) {
            return Collections.singletonList(Integer.parseInt(input));
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (isOperation(input.charAt(i))) {
                char op = input.charAt(i);
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        res.add(calculate(l, op, r));
                    }
                }
            }
        }
        return res;
    }

    public int calculate(int m, char op, int n) {
        switch (op) {
            case '+':
                return m + n;
            case '-':
                return m - n;
            case '*':
                return m * n;
        }
        return 0;
    }

    public boolean isOperation(char ch) {
        return ch == '+' || ch == '-' || ch == '*';
    }
}
