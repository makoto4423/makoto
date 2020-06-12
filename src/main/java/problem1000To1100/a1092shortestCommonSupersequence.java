package problem1000To1100;

import java.util.Arrays;
@Deprecated
public class a1092shortestCommonSupersequence {
    public String shortestCommonSupersequence(String str1, String str2) {
        String lcs = lcs(str1,str2);
        StringBuilder sb = new StringBuilder();
        int index1=0,index2=0;
        for(int i=0;i<lcs.length();i++,index1++,index2++){
            while(index1<str1.length() && str1.charAt(index1) != lcs.charAt(i)){
                sb.append(str1.charAt(index1++));
            }
            while (index2<str2.length() && str2.charAt(index2) != lcs.charAt(i)){
                sb.append(str2.charAt(index2++));
            }
            sb.append(lcs.charAt(i));
        }
        return sb.toString()+str1.substring(index1)+str2.substring(index2);
    }


    public String lcs(String str1,String str2){
        int len1 = str1.length();
        int len2 = str2.length();
        String[][] dp = new String[len1+1][len2+1];
        for(String[] d: dp){
            Arrays.fill(d,"");
        }
        for(int i=0;i<len1;i++){
            for(int j=0;j<len2;j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j]+str1.charAt(i);
                }else{
                    dp[i+1][j+1] = dp[i+1][j].length()>dp[i][j+1].length() ? dp[i+1][j] : dp[i][j+1];
                }
            }
        }
        return dp[len1][len2];
    }
}
