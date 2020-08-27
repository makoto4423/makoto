package problem100To200;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Deprecated
public class a139wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        Set<String> set = new HashSet<>(wordDict);
        dp[0] = true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] =true;break;
                }
            }
        }
        return dp[s.length()];
    }

}
