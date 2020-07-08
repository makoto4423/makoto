package problem900To1000;

public class a994orangesRotting {
    public int orangesRotting(int[][] grid) {
        int res = 0, xLen = grid.length, yLen = grid[0].length;
        boolean n = true;
        while (n){
            n = false;
            for(int i=0;i<xLen;i++){
                for(int j=0;j<yLen;j++){
                    if(grid[i][j] == 2){
                        if(i>0 && grid[i-1][j] == 1){
                            n = true;
                            grid[i-1][j] = -2;
                        }
                        if(j>0 && grid[i][j-1] == 1){
                            n = true;
                            grid[i][j-1] = -2;
                        }
                        if(i<xLen-1 && grid[i+1][j] == 1){
                            n = true;
                            grid[i+1][j] = -2;
                        }
                        if(j<yLen-1 && grid[i][j+1] == 1){
                            n = true;
                            grid[i][j+1] = -2;
                        }
                    }
                }
            }
            for(int i=0;i<xLen;i++){
                for(int j=0;j<yLen;j++){
                    if(grid[i][j] == -2){
                        grid[i][j] = 2;
                    }
                }
            }
            if(n)   res++;
        }
        for (int[] ints : grid) {
            for (int j = 0; j < yLen; j++) {
                if (ints[j] == 1) return -1;
            }
        }
        return res;
    }
}
