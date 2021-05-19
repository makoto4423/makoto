package problem1700To1800;

import java.util.PriorityQueue;

public class a1738kthLargestValue {
    public int kthLargestValue(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 && j == 0) {
                } else if (i == 0) {
                    matrix[i][j] ^= matrix[i][j - 1];
                } else if (j == 0) {
                    matrix[i][j] ^= matrix[i - 1][j];
                } else {
                    matrix[i][j] = matrix[i][j] ^ matrix[i - 1][j] ^ matrix[i][j - 1] ^ matrix[i - 1][j - 1];
                }
                if (queue.size() < k) {
                    queue.offer(matrix[i][j]);
                } else if (!queue.isEmpty()) {
                    int min = queue.peek();
                    if (min < matrix[i][j]) {
                        queue.poll();
                        queue.offer(matrix[i][j]);
                    }
                }
            }
        }
        return queue.isEmpty() ? -1 : queue.poll();
    }
}
