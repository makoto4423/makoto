package problem1000To1100;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class a1046lastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(i -> i * -1));
        for (int i : stones) {
            queue.add(i);
        }
        while (queue.size() > 1) {
            int y = queue.poll(), x = queue.poll();
            if (y != x) {
                queue.add(y - x);
            }
        }
        return queue.size() == 1 ? queue.poll() : 0;
    }
}
