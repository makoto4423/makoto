package problem500To600;

import java.util.Stack;

public class a547findCircleNum {
    public int findCircleNum(int[][] M) {
        int len = M.length, res = 0;
        if (len == 0) return res;
        int[] color = new int[len];
        for (int i = 0; i < len; i++) {
            if (color[i] != 0) continue;
            res++;
            Stack<Integer> stack = new Stack<>();
            stack.push(i);
            while (!stack.isEmpty()) {
                int j = stack.pop();
                if (color[j] != 0) continue;
                for (int m = 0; m < len; m++) {
                    if (M[j][m] == 1 && color[m] == 0) {
                        stack.push(m);
                    }
                    color[j] = res;
                }
            }
        }
        return res;
    }
}
