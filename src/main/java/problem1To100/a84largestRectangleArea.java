package problem1To100;

import java.util.Arrays;
import java.util.Stack;

// 单调栈，哨兵
@Deprecated
public class a84largestRectangleArea {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);
        }
        return res;
    }

//    public int largestRectangleArea(int[] heights) {
//        int n = heights.length;
//        int res = 0;
//        int[] dp = new int[n];
//        for (int i = 0; i < n; i++) {
//            int min = heights[i];
//            dp[i] = min;
//            res = Math.max(dp[i], res);
//            for (int j = i + 1; j < n; j++) {
//                min = Math.min(min, heights[j]);
//                dp[i] = Math.max(dp[i], min * (j - i + 1));
//                res = Math.max(dp[i], res);
//            }
//        }
//        return res;
//    }
}
