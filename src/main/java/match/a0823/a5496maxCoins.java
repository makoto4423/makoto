package match.a0823;

import java.util.Arrays;

public class a5496maxCoins {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int res = 0;
        int left = 0,right=piles.length-1;
        while (left-1 != right){
            res += piles[right-1];
            left++;
            right -= 2;
        }
        return res;
    }
}
