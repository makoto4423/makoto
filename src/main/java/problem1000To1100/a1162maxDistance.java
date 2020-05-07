package problem1000To1100;

import java.util.ArrayList;
import java.util.List;
// 还是之前的“污染”算法
public class a1162maxDistance {
    int[][] grid;
    int xLen;
    int yLen;

    public int maxDistance(int[][] grid) {
        this.grid = grid;
        this.xLen = grid.length;
        this.yLen = grid[0].length;
        int max = 0;
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if(grid[i][j] == 0){
                    int cnt = count(i,j,1);
                    max = Math.max(max,cnt);
                }
            }
        }
        return max == 0 ? -1 : max;
    }

    public int count(int x, int y, int dis){
        if(dis >xLen+yLen)
            return -1;
        for(int i=0;i<=dis;i++){
            if(x+i<xLen && y+dis-i<yLen && grid[x+i][y+dis-i] == 1){
                return dis;
            }
            if(x-i>=0 && y+dis-i<yLen && grid[x-i][y+dis-i] == 1){
                return dis;
            }
            if(x+i<xLen && y-dis+i>= 0 && grid[x+i][y-dis+i] == 1){
                return dis;
            }
            if(x-i>=0 && y-dis+i>=0 && grid[x-i][y-dis+i] == 1){
                return dis;
            }
        }
        return count(x,y,++dis);
    }
}
