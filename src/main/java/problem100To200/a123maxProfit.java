package problem100To200;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Deprecated
public class a123maxProfit {
    public int maxProfit(int[] prices) {
        int buy1=Integer.MIN_VALUE,sell1=0,buy2=Integer.MIN_VALUE,sell2=0;
        for(int p : prices){
            buy1 = Math.max(buy1,-p);
            sell1 = Math.max(sell1,buy1+p);
            buy2 = Math.max(buy2,sell1-p);
            sell2 = Math.max(sell2,buy2+p);
        }
        return sell2;
    }
}
