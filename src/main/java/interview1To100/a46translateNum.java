package interview1To100;

public class a46translateNum {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        if(len < 2)    return 1;
        int[] dp = new int[len+1];
        dp[0] = 1; dp[1] =1 ;
        for(int i=1;i<len;i++){
            if(s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i) < '6')){
                dp[i+1] = dp[i] + dp[i-1];
            }else{
                dp[i+1] = dp[i];
            }
        }
        return dp[len];
    }
}
