package problem600To700;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class a621leastInterval {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        for(char ch: tasks){
            arr[ch-'A']++;
        }
        Arrays.sort(arr);
        int maxVal = arr[25]-1, idle = maxVal*n;
        for(int i=0; i<25; i++){
            idle -= Math.min(arr[i],maxVal);
        }
        return idle>0 ? idle+tasks.length : tasks.length;
//        自己想出来的桶排序，不过写到一般卡住了
//        if(n==0)    return tasks.length;
//        int[] arr = new int[26];
//        for(char ch: tasks){
//            arr[ch-'A']++;
//        }
//        int max = -1,cnt=-1;
//        for(int i=0; i<26 ;i++){
//            if(arr[i] > cnt){
//                max = i;
//                cnt = arr[i];
//            }
//        }
//        if((cnt-1)*(n+1)>=tasks.length){
//            return (cnt-1)*(n+1)+1;
//        }else{
//            return tasks.length;
//        }

    }
}
