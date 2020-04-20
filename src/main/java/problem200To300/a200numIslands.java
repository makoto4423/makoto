package problem200To300;

// 姑且算作深度优先搜索
public class a200numIslands {

    int xLen;
    int yLen;

    public int numIslands(char[][] grid) {
        int cnt =0;
        xLen = grid.length;
        if(xLen == 0)   return 0;
        yLen = grid[0].length;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(help(i,j,grid)){
                    cnt++;
                    convert(i,j,grid);
                }
            }
        }
        return cnt;
    }

    public boolean help(int x, int y, char[][] grid){
        if(grid[x][y] != '1')   return false;
        if(x>=1 && y>= 1){
            return grid[x-1][y] == '0' && grid[x][y-1] == '0';
        }else if(x>=1){
            return grid[x-1][y] == '0';
        }else if(y>=1){
            return grid[x][y-1] == '0';
        }else{
            return true;
        }
    }

    public void convert(int x, int y, char[][] grid){
        grid[x][y] = 'a';
        if(x-1>= 0 && grid[x-1][y] == '1'){
            convert(x-1,y,grid);
        }
        if(x+1<xLen && grid[x+1][y] == '1'){
            convert(x+1,y,grid);
        }
        if(y-1>=0 && grid[x][y-1] == '1'){
            convert(x,y-1,grid);
        }
        if(y+1<yLen && grid[x][y+1] == '1'){
            convert(x,y+1,grid);
        }
    }


}
