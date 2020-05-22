package problem800To900;

import java.util.*;

// 图的遍历，寻找是否存在环，若存在判断环的边数，偶数为true，奇数为false,然后又卡住了。。
// 官方答案并没有去寻找环
@Deprecated
public class a886possibleBipartition {

    List<List<Integer>> graph = new ArrayList<>();
    Map<Integer, Integer> color = new HashMap<>();

    public boolean possibleBipartition(int N, int[][] dislikes) {
        for (int i = 0; i < N + 1; i++) {
            List<Integer> list = new ArrayList<>();
            graph.add(list);
        }
        for(int[] dislike : dislikes){
            graph.get(dislike[0]).add(dislike[1]);
            graph.get(dislike[1]).add(dislike[0]);
        }
        for(int i=1;i<N+1;i++){
            if(!color.containsKey(i)){
                boolean b = dfs(i,0);
                if(!b)  return false;
            }
        }
        return true;

    }

    public boolean dfs(int place,int c){
        if(color.containsKey(place)){
            return color.get(place) == c;
        }
        color.put(place,c);
        for(Integer i : graph.get(place)){
            boolean b = dfs(i,c^1);
            if(!b)  return false;
        }
        return true;
    }

}
