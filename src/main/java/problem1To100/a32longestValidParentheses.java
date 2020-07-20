package problem1To100;

import java.util.Stack;

/**
 * 原本是想出有效()开始找最大的有效字符串，但是往左还是往右无法解决
 */
@Deprecated
public class a32longestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] sign = new int[s.length()];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                sign[i] = 1;
                stack.push(i);
            }else{
                if(stack.isEmpty()){
                    sign[i] = 1;
                }else{
                    int left = stack.pop();
                    sign[left] = 0;
                    sign[i] = 0;
                }
            }
        }
        int res = 0, temp = 0;
        for(int i : sign){
            if(i==0){
                temp++;
            }else{
                res = Math.max(res,temp);
                temp = 0;
            }
        }
        return Math.max(res,temp);
    }

//    补一个最佳的答案吧，而且估计也是最好理解的了
//    int left = 0, right = 0, maxlength = 0;
//        for (int i = 0; i < s.length(); i++) {
//        if (s.charAt(i) == '(') {
//            left++;
//        } else {
//            right++;
//        }
//        if (left == right) {
//            maxlength = Math.max(maxlength, 2 * right);
//        } else if (right > left) {
//            left = right = 0;
//        }
//    }
//    left = right = 0;
//        for (int i = s.length() - 1; i >= 0; i--) {
//        if (s.charAt(i) == '(') {
//            left++;
//        } else {
//            right++;
//        }
//        if (left == right) {
//            maxlength = Math.max(maxlength, 2 * left);
//        } else if (left > right) {
//            left = right = 0;
//        }
//    }
//        return maxlength;
//
//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
