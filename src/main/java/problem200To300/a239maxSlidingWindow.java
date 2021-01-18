package problem200To300;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// 数组，单调队列（双向队列）
// 简单的用优先队列会超时，原因是因为需要遍历优先队列，把超出滑动窗口的元素去除，我的写法是把相同元素的去掉
// 其实，直接把坐标一同放入优先队列中，当出栈一个元素超出滑动窗口范围，则取下一个即可
@Deprecated
public class a239maxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<int[]> queue = new PriorityQueue<>((i,j)->{
            if(i[0] == j[0]){
                return i[1]-j[1];
            }
            return j[0]-i[0];
        });
        for(int i=0;i<k-1;i++){
            queue.add(new int[]{nums[i],i});
        }
        int len = nums.length;
        int[] res = new int[len-k+1];
        int index = 0;
        for(int i=k-1;i<len;i++){
            queue.add(new int[]{nums[i],i});
            while (queue.peek()[1] <= i - k) {
                queue.poll();
            }
            res[index++] = queue.peek()[0];
        }
        return res;
    }
}
