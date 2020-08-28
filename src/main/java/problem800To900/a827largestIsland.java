package problem800To900;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class a827largestIsland {
    int xLen;
    int yLen;
    int[] xGrid = {1,0,-1,0};
    int[] yGrid = {0,1,0,-1};
    int[][] grid;
    public int largestIsland(int[][] grid) {
        xLen = grid.length;
        yLen = grid[0].length;
        this.grid = grid;
        calculate();
        int res = 0;
        for(int i=0;i<xLen;i++){
            for(int j=0;j<yLen;j++){
                if(grid[i][j] == 0){
                    int temp = 1;
                    for(int m=0;m<4;m++){
                        int x = i+xGrid[m],y=j+ yGrid[m];
                        if(x>=0 && x<xLen && y>=0 && y<yLen){
                            temp+= grid[x][y];
                        }
                    }
                    res = Math.max(temp,res);
                }else{
                    res = Math.max(grid[i][j],res);
                }
            }
        }
        return res;
    }

    public void calculate(){
        for(int i=0;i<xLen;i++){
            for(int j=0;j<yLen;j++){
                if(grid[i][j] == 1){
                    Queue<Point> queue = new LinkedList<>();
                    Set<Point> set = new HashSet<>();
                    boolean[][] visited = new boolean[xLen][yLen];
                    int area = 0;
                    queue.add(new Point(i,j));
                    while (!queue.isEmpty()){
                        Point p = queue.poll();
                        if(visited[p.x][p.y]){
                            continue;
                        }
                        set.add(p);
                        visited[p.x][p.y] = true;
                        area++;
                        for(int m=0;m<4;m++){
                            int x = p.x+xGrid[m],y=p.y+ yGrid[m];
                            if(x>=0 && x<xLen && y>=0 && y<yLen && !visited[x][y] && grid[x][y] == 1){
                                queue.add(new Point(x,y));
                            }
                        }
                    }
                    for(Point p : set){
                        grid[p.x][p.y] = area;
                    }
                }
            }
        }
    }

    public static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
