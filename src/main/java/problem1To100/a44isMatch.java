package problem1To100;

/**
 * 尽力了，暴力只能通过到1708 / 1809，把连续*号的也优化了也是timeout,讨论区有人说要剪枝。。。。算了还是按照答案dp一把梭
 */
@Deprecated
public class a44isMatch {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; ++i) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
//    public boolean isMatch(String s, String p) {
//        if(s.length() == 0 && p.length() == 0)  return true;
//        return recur(s,p,0,0);
//    }
//
//    public boolean recur(String s, String p, int i, int j){
//        if(i == s.length() && j == p.length()){
//            return true;
//        }else if(i == s.length()){
//            for(int m = j;m<p.length();m++){
//                if(p.charAt(m) != '*')  return false;
//            }
//            return true;
//        }else if(j == p.length()){
//            return false;
//        }
//        if(p.charAt(j) == '?'){
//            return recur(s, p, i+1, j+1);
//        }else if(p.charAt(j) == '*'){
//            int n = 1;
//            for(;j+n<p.length();j++){
//                if(p.charAt(j+n) != '*'){
//                    break;
//                }
//            }
//            for(int m=0;m<=s.length()-i;m++){
//                if(recur(s,p,i+m,j+n)){
//                    return true;
//                }
//            }
//            return false;
//        }else if(p.charAt(j) != s.charAt(i)){
//            return false;
//        }
//        return recur(s, p, i+1, j+1);
//    }
}
