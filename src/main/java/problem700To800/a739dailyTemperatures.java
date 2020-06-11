package problem700To800;

import java.util.Stack;

public class a739dailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<len;i++){
           while(!stack.isEmpty() && T[stack.peek()] < T[i]){
               int index = stack.pop();
               res[index] = i-index;
           }
           stack.push(i);
        }
        return res;
//        int len = T.length;
//        if(len == 0)    return new int[]{};
//        int[] res = new int[len];
//        res[len-1] = 0;
//        for(int i=len-2;i>=0;i--){
//            for(int j=i+1;j<len;j++){
//                if(T[j] > T[i]){
//                    res[i] = j-i;break;
//                }
//            }
//        }
//        return res;
    }
}
