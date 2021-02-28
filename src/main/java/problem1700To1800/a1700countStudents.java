package problem1700To1800;

import java.util.LinkedList;
import java.util.Queue;

public class a1700countStudents {
    public int countStudents(int[] students, int[] sandwiches) {
        int size = students.length, i = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int stu : students) {
            queue.offer(stu);
        }
        Queue<Integer> another = new LinkedList<>();
        boolean has = true;
        while (has) {
            has = false;
            while (!queue.isEmpty()) {
                int stu = queue.poll();
                if (stu == sandwiches[i]) {
                    i++;
                    size--;
                    has = true;
                } else {
                    another.add(stu);
                }
            }
            queue = another;
            another = new LinkedList<>();
        }
        return size;
    }
}
