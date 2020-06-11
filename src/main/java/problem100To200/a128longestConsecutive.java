package problem100To200;

import java.util.Stack;
@Deprecated
public class a128longestConsecutive {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for(int num : nums){
            stack.add(num);
        }
        for(int num : stack){
            if(!stack.contains(num-1)){
                int len = 1;
                while(stack.contains(num+1)){
                    len++;
                    num++;
                }
                max = Math.max(len,max);
            }
        }
        return max;
    }
}
