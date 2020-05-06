package interview1To100;

import java.util.Stack;

// 还想用快慢指针模拟减少点内存消耗，写了半天出不来，简单粗暴直接用stack一下搞定
public class a31validateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j=0;
        for(int i=0;i<popped.length;){
            if(!stack.isEmpty() && stack.peek() == popped[i]){
                stack.pop();
                i++;
            }else if(j < pushed.length){
                stack.push(pushed[j++]);
            }else{
                return false;
            }
        }
        return true;
    }
}
