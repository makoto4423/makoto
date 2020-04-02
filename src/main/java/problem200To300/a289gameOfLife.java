package problem200To300;

public class a289gameOfLife {
    public void gameOfLife(int[][] board) {
        int xLen = board.length;
        int yLen = board[0].length;
        if(yLen==0) return;
        int[][] result = new int[xLen][yLen];
        if(xLen == 1){
            result[0][0] = 1;result[0][yLen-1]=0;
            for(int j=1; j<yLen-1; j++){
                int cnt = board[0][j-1]+board[0][j+1];
                if(board[0][j] == 0){
                    if(cnt ==3){
                        result[0][j] = 1;
                    }else {
                        result[0][j] = 0;
                    }
                }else{
                    if(cnt == 2 || cnt == 3){
                        result[0][j] = 1;
                    }else {
                        result[0][j] = 0;
                    }
                }
            }
        }else if(yLen == 1){
            result[0][0] = 1;result[xLen-1][0]=0;
            for(int i=1; i<xLen-1; i++){
                int cnt = board[i-1][0]+board[i+1][0];
                if(board[i][0] == 0){
                    if(cnt ==3){
                        result[i][0] = 1;
                    }else {
                        result[i][0] = 0;
                    }
                }else{
                    if(cnt == 2 || cnt == 3){
                        result[i][0] = 1;
                    }else {
                        result[i][0] = 0;
                    }
                }
            }
        }else{
            for(int i=0; i<xLen; i++){
                for(int j=0; j<yLen; j++){
                    int cnt = calculate(i,j,board);
                    if(board[i][j] == 0){
                        if(cnt ==3){
                            result[i][j] = 1;
                        }else {
                            result[i][j] = 0;
                        }
                    }else{
                        if(cnt == 2 || cnt == 3){
                            result[i][j] = 1;
                        }else {
                            result[i][j] = 0;
                        }
                    }
                }
            }
        }
        for(int i=0; i<xLen;i++){
            System.arraycopy(result[i], 0, board[i], 0, yLen);
        }
    }

    public int calculate(int x, int y, int[][] board){
        int xLen = board.length;
        int yLen = board[0].length;
        int cnt = 0;
        if(x-1>=0 && y-1>=0){
            if(x+1<xLen && y+1<yLen){
                cnt += board[x-1][y-1]+board[x][y-1]+board[x+1][y-1]
                        +board[x-1][y]+board[x+1][y]
                        +board[x-1][y+1]+board[x][y+1]+board[x+1][y+1];
            }else{
                cnt += board[x-1][y-1]+board[x][y-1]+board[x-1][y];
                if(x+1<xLen){
                    cnt+= board[x+1][y-1]+board[x+1][y];
                }else if(y+1<yLen){
                    cnt+= board[x-1][y+1]+board[x][y+1];
                }
            }
        }else if(x+1<xLen && y+1<yLen){
            cnt += board[x][y+1]+board[x+1][y+1]+board[x+1][y];
            if(x+1<xLen&&y-1>=0){
                cnt+= board[x][y-1]+board[x+1][y-1];
            }else if(x-1>=0){
                cnt+= board[x-1][y+1]+board[x-1][y];
            }
        }else if(x-1>=0 && y+1<yLen){
            cnt+= board[x-1][y]+board[x-1][y+1]+board[x][y+1];
        }else{
            cnt+= board[x][y-1]+board[x+1][y-1]+board[x+1][y];
        }
        return cnt;
    }
}
