package problem800To900;

import java.util.Arrays;

public class a888fairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        long alice = 0,bob = 0;
        for(int i : A){
            alice+=i;
        }
        for(int i : B){
            bob += i;
        }
        for (int k : A) {
            for (int i : B) {
                if (alice - k + i == bob + k - i) {
                    return new int[]{k, i};
                }
            }
        }
        return null;
    }
}
