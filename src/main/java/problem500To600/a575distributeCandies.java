package problem500To600;

import java.util.HashSet;
import java.util.Set;

public class a575distributeCandies {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        int dif = 0;
        for (int candy : candyType) {
            if (!set.contains(candy)) {
                dif++;
            }
            set.add(candy);
        }
        int n = candyType.length;
        return Math.min(dif, n / 2);
    }
}
