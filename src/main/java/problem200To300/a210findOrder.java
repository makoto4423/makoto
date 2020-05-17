package problem200To300;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class a210findOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses == 0)    return new int[0];
        int[] inDegree = new int[numCourses];
        for(int[] i : prerequisites){
            inDegree[i[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i] == 0)  queue.offer(i);
        }
        int count = 0;
        int[] res = new int[numCourses];
        while (!queue.isEmpty()){
            int pre = queue.poll();
            res[count++] = pre;
            for(int[] i : prerequisites){
                if(i[1] == pre){
                    inDegree[i[0]]--;
                    if(inDegree[i[0]] == 0) queue.offer(i[0]);
                }
            }
        }
        if(count == numCourses) return res;
        return new int[0];
    }

}
