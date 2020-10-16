package interview1To100;

import java.util.Comparator;
import java.util.PriorityQueue;

public class a1714smallestK {
    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : arr) {
            queue.add(i);
        }
        int[] res = new int[k];
        for (int i = 0; i < k && queue.size() != 0; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}
