package lcp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a03robot {
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] i : obstacles){
            List<Integer> list = map.getOrDefault(i[0], new ArrayList<>());
            list.add(i[1]);
            map.put(i[0],list);
        }
        Point pos = new Point(0, 0);
        while (pos.getX() <= x && pos.getY() <= y){
            for(char ch : command.toCharArray()){
                if(pos.getX() == x && pos.getY() == y){
                    return true;
                }
                if(ch == 'U'){
                    pos.setY(pos.getY()+1);
                }
                if(ch == 'R'){
                    pos.setX(pos.getX()+1);
                }
                List<Integer> list = map.get(pos.getX());
                if(list != null && list.contains(pos.getY())){
                    return false;
                }
            }
        }
        return false;
    }

    public static class Point{
        int x;
        int y;
        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
