package problem300To400;

import java.util.*;

// 答案也是用优先队列，不过没有构建对象而是通过不断的比较将频率较少的数字出列
public class a347topKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> stat = new HashMap<>();
        for(int num : nums){
            stat.merge(num, 1, Integer::sum);
        }
        List<Struct> list = new ArrayList<>();
        stat.forEach((key,value)->{
            Struct struct = new Struct();
            struct.index = key;
            struct.cnt = value;
            list.add(struct);
        });
        // PriorityQueue是最小堆，*-1将其变成最大堆
        PriorityQueue<Struct> queue = new PriorityQueue<>(list.size(),Comparator.comparingInt(o -> o.cnt*(-1)));
        queue.addAll(list);
        int[] res = new int[k];
        for(int i=0; i<k; i++){
            res[i] = Objects.requireNonNull(queue.poll()).index;
        }
        return res;
    }

    private static class Struct{
        public int index;
        public int cnt;
    }
}
