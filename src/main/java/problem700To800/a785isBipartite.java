package problem700To800;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a785isBipartite {
    boolean res = true;

    public boolean isBipartite(int[][] graph) {
        char[] color = new char[graph.length];
        Arrays.fill(color, 'w');
        paint(color, graph);
        return res;
    }

    public void paint(char[] color, int[][] graph){
        all : for(int i=0;i<color.length;i++){
            if(color[i] != 'w') continue;
            color[i] = 'r';
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<graph[i].length;j++){
                list.add(graph[i][j]);
            }
            char now = 'b';
            boolean n = true;
            while (n){
                n = false;
                List<Integer> child = new ArrayList<>();
                for(Integer index : list){
                    for(int j=0;j<graph[index].length;j++){
                        if(color[index] == 'w'){
                            child.add(graph[index][j]);
                        }
                    }
                    if(color[index] == 'w'){
                        color[index] = now;
                        n = true;
                    }else if(color[index] != now){
                        res = false;
                        break all;
                    }

                    list = child;
                }
                now = now == 'b' ? 'r' : 'b';
            }
        }
    }

}
