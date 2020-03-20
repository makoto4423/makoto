import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class a20isValid {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');map.put(']','[');map.put('}','{');
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' ||s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }else{
                if(stack.isEmpty() || stack.pop() != map.get(s.charAt(i))) return false;
            }
        }
        return stack.isEmpty();

    }
}
