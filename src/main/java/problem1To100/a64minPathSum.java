package problem1To100;

public class a64minPathSum {
    public int minPathSum(int[][] grid) {
        int xLen = grid.length;
        if(xLen == 0) return -1;
        int yLen = grid[0].length;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i == 0 && j==0) continue;
                if(i==0)    {
                    grid[i][j] += grid[i][j-1];
                }else if(j==0){
                    grid[i][j] += grid[i-1][j];
                }else{
                    grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);
                }
            }
        }
        return grid[xLen-1][yLen-1];
    }
}
