package problem100To200;

@Deprecated
public class a122maxProfit {
    public int maxProfit(int[] prices) {
        int max = 0, i=0;
        int len = prices.length;
        while(i<len-1){
            while(i<len-1 && prices[i] >=prices[i+1]){
                i++;
            }
            int valley = prices[i];
            while(i<len-1 && prices[i] <= prices[i+1]){
                i++;
            }
            int peak = prices[i];
            max += peak-valley;
        }
        return max;
    }
}
