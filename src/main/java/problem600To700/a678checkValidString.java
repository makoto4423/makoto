package problem600To700;

import java.util.Stack;
// 写了两次种解法，一个timeout，一个error，吐血
@Deprecated
public class a678checkValidString {
    public boolean checkValidString(String s) {
        // possible range
        int min = 0, max = 0; // 维护当前左括号的数量范围：[min, max]
        for (char c : s.toCharArray()) {
            if (c == '(') {
                ++min;
                ++max;
            } else if (c == ')') {
                if (min > 0) min--;
                if (max-- == 0) return false;// 左括号不够
            } else {
                if (min > 0) min--; // 可作为右括号，抵消
                ++max; // 可作为左括号
            }
        }
        return min == 0;
    }

    // error,stack里面放‘（’的索引，cnt改为‘*’的索引，index == s.length的时候一起遍历，
    // 若左索引大于星索引，return false
//    public boolean checkValidString(String s) {
//        return dp(s, new Stack<>(),0,0);
//    }
//
//    public boolean dp(String s, Stack<Character> stack,int cnt, int index){
//        if(index == s.length()){
//            return stack.isEmpty() || stack.size() == cnt;
//        }
//        if(s.charAt(index) == '('){
//            stack.push('(');
//        }else if(s.charAt(index) == ')'){
//            if(!stack.isEmpty() && stack.peek() == '('){
//                stack.pop();
//            }else if(cnt > 0){
//                cnt--;
//            }else{
//                return false;
//            }
//        }else{
//            cnt++;
//        }
//        return dp(s, stack, cnt, ++index);
//    }

//    timeout
//    public boolean checkValidString(String s) {
//        return dp(s, new Stack<>(),0);
//    }
//
//    public boolean dp(String s, Stack<Character> stack, int index){
//        if(index == s.length()) return stack.isEmpty();
//        if(s.charAt(index) == '('){
//            stack.push('(');
//        }else if(s.charAt(index) == ')'){
//            if(stack.isEmpty() || stack.pop() != '('){
//                return false;
//            }
//        }else{
//            Stack<Character> sec = new Stack<>();sec.addAll(stack);
//            sec.push('(');
//            ++index;
//            Stack<Character> thi = new Stack<>();thi.addAll(stack);
//            return dp(s,sec,index)
//                    || (!thi.isEmpty() && thi.pop() == '(' && dp(s,thi,index))
//                    || dp(s,stack,index);
//        }
//        return dp(s, stack, ++index);
//    }

}
