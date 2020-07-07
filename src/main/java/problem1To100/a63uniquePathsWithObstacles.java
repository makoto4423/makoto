package problem1To100;

public class a63uniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int xLen = obstacleGrid.length;
        if(xLen == 0)   return 0;
        int yLen = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1) return 0;
        if(obstacleGrid[xLen-1][yLen-1] == 1)   return 0;
        obstacleGrid[0][0] = 1;
        for(int i=0;i<xLen;i++){
            for(int j=0;j<yLen;j++){
                if(i==0 && j==0)    continue;
                if(obstacleGrid[i][j] == 1){
                    obstacleGrid[i][j] = -1;continue;
                }
                int xPre = 0;
                if(i>=1 && obstacleGrid[i-1][j] != -1){
                    xPre = obstacleGrid[i-1][j];
                }
                int yPre = 0;
                if(j>=1 && obstacleGrid[i][j-1] != -1){
                    yPre = obstacleGrid[i][j-1];
                }
                obstacleGrid[i][j] = xPre+yPre;
            }
        }
        return obstacleGrid[xLen-1][yLen-1];
    }
}
