package problem500To600;

public class a509fib {

    int[] dp;

    public int fib(int n) {
        dp = new int[n+1];
        return help(n);
    }

    public int help(int n){
        if(n == 0){
            dp[0] = 0;
            return dp[0];
        }
        if(n == 1){
            dp[1] = 1;
            return 1;
        }
        if(dp[n] == 0){
            dp[n] = help(n-1)+help(n-2);
        }
        return dp[n];
    }

}
