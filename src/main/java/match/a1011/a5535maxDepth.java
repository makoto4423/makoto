package match.a1011;

public class a5535maxDepth {
    public int maxDepth(String s) {
        int left = 0,res=0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                left++;
            }else if(ch == ')'){
                res = Math.max(left,res);
                left--;
            }
        }
        return res;
    }
}
