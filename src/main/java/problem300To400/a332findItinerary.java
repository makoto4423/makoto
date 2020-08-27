package problem300To400;

import java.util.*;

// lc是不是把要求放松了，近乎蛮力的也能通过，答案 9ms , 我 57ms
// 感觉图的基础不行啊
public class a332findItinerary {
    Map<String, PriorityQueue<String>> map;
    List<String> res;

    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<>();
        res = new ArrayList<>();
        for(List<String> list : tickets){
            if(!map.containsKey(list.get(0))){
                map.put(list.get(0),new PriorityQueue<>());
            }
            map.get(list.get(0)).offer(list.get(1));
        }
        dfs("JFK");
        Collections.reverse(res);
        return res;
    }

    public void dfs(String s){
        while (map.containsKey(s) && map.get(s).size() > 0){
            String a = map.get(s).poll();
            dfs(a);
        }
        res.add(s);
    }
//    public List<String> findItinerary(List<List<String>> tickets) {
//        boolean[] visited = new boolean[tickets.size()];
//        List<String> res = new ArrayList<>();
//        res.add("JFK");
//        help(res, visited, tickets);
//        return res;
//    }
//
//    public boolean help(List<String> res, boolean[] visited, List<List<String>> tickets) {
//        if (res.size() == tickets.size() + 1) {
//            return true;
//        }
//        String pre = res.get(res.size() - 1);
//        List<Point> choose = new ArrayList<>();
//        for (int i = 0; i < tickets.size(); i++) {
//            if (tickets.get(i).get(0).equals(pre) && !visited[i]) {
//                Point p = new Point(tickets.get(i).get(1), i);
//                choose.add(p);
//            }
//        }
//        choose.sort(Comparator.comparing(o -> o.s));
//        for (Point p : choose) {
//            boolean[] chooseVisited = new boolean[visited.length];
//            System.arraycopy(visited, 0, chooseVisited, 0, visited.length);
//            chooseVisited[p.i] = true;
//            res.add(p.s);
//            if (help(res, chooseVisited, tickets)) {
//                return true;
//            } else {
//                res.remove(res.size() - 1);
//            }
//        }
//        return false;
//    }
//
//    public static class Point {
//        public String s;
//        public int i;
//
//        public Point(String s, int i) {
//            this.s = s;
//            this.i = i;
//        }
//    }
}
