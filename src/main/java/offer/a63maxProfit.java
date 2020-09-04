package offer;

public class a63maxProfit {
    public int maxProfit(int[] prices) {
        if(prices.length == 0)  return 0;
        int min = prices[0], res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                for (int j = i + 1; j < prices.length; j++) {
                    if (prices[j] < prices[j - 1]) {
                        res = Math.max(res, prices[j - 1] - min);
                        i = j - 2;
                        break;
                    }
                }
            } else {
                min = Math.min(prices[i + 1], min);
            }
        }
        return Math.max(res,prices[prices.length-1]-min);
    }
}
