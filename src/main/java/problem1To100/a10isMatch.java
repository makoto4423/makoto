package problem1To100;

@Deprecated
public class a10isMatch {
    Boolean[][] memo;

    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length()+1][p.length()+1];
        return dp(0,0,s,p);
    }

    public boolean dp(int i, int j, String s, String p){
        if(memo[i][j] != null){
            return memo[i][j] == Boolean.TRUE;
        }
        boolean res;
        if(j == p.length()){
            res = i == s.length();
        }else{
            boolean firstMatch = i < s.length() &&
                    (s.charAt(i) == p.charAt(j)
                            || p.charAt(j) == '.');
            if(j+1<p.length() && p.charAt(j+1) == '*'){
                res = (firstMatch && dp(i+1,j,s,p)) || dp(i,j+2,s,p);
            }else{
                res = firstMatch && dp(i+1,j+1,s,p);
            }
            memo[i][j] = res;
        }
        return res;
    }

}
