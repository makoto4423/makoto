package problem1000To1100;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
// 滑动窗口就能搞定的事，想什么先进先出用队列啊。。。。。
public class a1004longestOnes {
    public int longestOnes(int[] A, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i<K;i++){
            queue.add(-1);
        }
        int max = 0,cnt=0;
        for(int i=0; i<A.length; i++){
            if(A[i] == 1){
                cnt++;
            }else if(!queue.isEmpty() && queue.peek() == -1){
                queue.poll();
                queue.add(i);
                cnt++;
            }else if(!queue.isEmpty()){
                max = Math.max(cnt,max);
                int last = queue.poll();
                cnt = i-last;
                queue.add(i);
            }else{
                max = Math.max(cnt,max);
                cnt=0;
            }
        }
        max = Math.max(cnt,max);
        return max;
    }
}
