package interview1To100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 递归，一生之敌, 看了一遍答案再写一遍
public class a0802pathWithObstacles {
    private int m,n;
    private int[][] grid;
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        this.grid = obstacleGrid;
        m = this.grid.length;
        n = this.grid[0].length;
        List<List<Integer>> list = new ArrayList<>();
        dfs(0,0,new boolean[m][n], list);
        return list;
    }

    private boolean dfs(int row, int col, boolean[][] visited, List<List<Integer>> pathList) {
        if(row >= m || col >= n || grid[row][col] == 1 || visited[row][col]){
            return false;
        }
        pathList.add(Arrays.asList(row,col));

        if(row == m-1 && col == n-1){
            return true;
        }
        visited[row][col] = true;
        if(dfs(row,col+1,visited, pathList) || dfs(row+1, col, visited, pathList)){
            return true;
        }
        pathList.remove(pathList.size()-1);
        return false;
    }

}
