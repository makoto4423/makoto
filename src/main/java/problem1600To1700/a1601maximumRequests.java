package problem1600To1700;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// {2,0},{0,4},{3,1},{2,4},{1,3},{4,2},{4,3},{0,1}  5
// 拓扑无法解决，把所有非环的边去掉，但是也会存在两个独立的环通过单向边相连的情况，
// 只能通过dfs去判断，出度能否回到原点，但这样和暴力无异，想不出有什么好的解决办法
// dfs
@Deprecated
public class a1601maximumRequests {

    int max;
    public int maximumRequests(int n, int[][] requests) {
        max = 0;
        int[] arr = new int[n];
        recur(requests,arr,0,0);
        return max;
    }

    public void recur(int[][] requests,int[] arr,int count,int index){
        if(check(arr)){
            max = Math.max(max,count);
        }
        for(int i=index;i<requests.length;i++){
            arr[requests[i][0]]++;
            arr[requests[i][1]]--;
            recur(requests,arr,count+1,i+1);
            arr[requests[i][0]]--;
            arr[requests[i][1]]++;
        }
    }

    public boolean check(int[] arr){
        for(int i : arr){
            if(i != 0) return false;
        }
        return true;
    }

//    public int maximumRequests(int n, int[][] requests) {
//        List<List<Integer>> inAdj = new ArrayList<>();
//        List<List<Integer>> outAdj = new ArrayList<>();
//        int[] inDegree = new int[n];
//        int[] outDegree = new int[n];
//        for (int i = 0; i < n; i++) {
//            inAdj.add(new ArrayList<>());
//            outAdj.add(new ArrayList<>());
//        }
//        int res = 0;
//        for (int[] req : requests) {
//            if(req[0] == req[1]){
//                res++;
//            }else{
//                inAdj.get(req[0]).add(req[1]);
//                inDegree[req[1]]++;
//                outAdj.get(req[1]).add(req[0]);
//                outDegree[req[0]]++;
//            }
//        }
//        Queue<Integer> queue = new LinkedList<>();
//        for(int i=0;i<n;i++){
//            if(inDegree[i] == 0){
//                queue.add(i);
//            }
//        }
//        while (!queue.isEmpty()){
//            int front = queue.poll();
//            for(int i : inAdj.get(front)){
//                inDegree[i]--;
//                if(inDegree[i] == 0){
//                    queue.add(i);
//                }
//                outDegree[front]--;
//                outAdj.get(i).remove(new Integer(front));
//            }
//        }
//        for(int i=0;i<n;i++){
//            if(outDegree[i] == 0){
//                queue.add(i);
//            }
//        }
//        while (!queue.isEmpty()){
//            int aft = queue.poll();
//            for(int i : outAdj.get(aft)){
//                outDegree[i]--;
//                if(outDegree[i] == 0){
//                    queue.add(i);
//                }
//                inDegree[aft]--;
//            }
//        }
//
//        for(int i=0;i<n;i++){
//            res += Math.min(inDegree[i],outDegree[i]);
//        }
//        return res;
//    }
}
