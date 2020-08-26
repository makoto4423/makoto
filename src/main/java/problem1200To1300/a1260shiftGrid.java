package problem1200To1300;

import java.util.ArrayList;
import java.util.List;

public class a1260shiftGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int xLen = grid.length;
        if(xLen == 0)   return new ArrayList<>();
        int yLen = grid[0].length;
        int[][] matrix = new int[xLen][yLen];
        while(k>0){
            for(int i=0;i<xLen;i++){
                if (yLen - 1 >= 0) System.arraycopy(grid[i], 0, matrix[i], 1, yLen - 1);
            }
            for(int i=1;i<xLen;i++){
                matrix[i][0] = grid[i-1][yLen-1];
            }
            matrix[0][0] = grid[xLen-1][yLen-1];
            for(int i=0;i<xLen;i++){
                System.arraycopy(matrix[i], 0, grid[i], 0, yLen);
            }
            k--;
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int[] ints : grid) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < yLen; j++) {
                list.add(ints[j]);
            }
            res.add(list);
        }
        return res;
    }
}
