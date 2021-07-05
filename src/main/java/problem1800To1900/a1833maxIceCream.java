package problem1800To1900;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

// 有计数排序版本，能把时间复杂度降到线性
public class a1833maxIceCream {
    public int maxIceCream(int[] costs, int coins) {
        PriorityQueue<Integer> queue = Arrays.stream(costs).boxed().collect(Collectors.toCollection(PriorityQueue::new));
        int res = 0;
        while (!queue.isEmpty() && coins > 0){
            int cost = queue.poll();
            if(cost <= coins){
                res++;
                coins -= cost;
            }
        }
        return res;
    }
}
