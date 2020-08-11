package problem100To200;

import java.util.LinkedList;
import java.util.Queue;

public class a130solve {
    public void solve(char[][] board) {
        int xLen = board.length;
        if(xLen < 3)    return;
        int yLen = board[0].length;
        if(yLen < 3)    return;
        Queue<Point> queue = new LinkedList<>();
        for(int i=0;i<xLen;i++){
            if(board[i][0] == 'O'){
                board[i][0] = 'a';
                queue.add(new Point(i,0));
            }
            if(board[i][yLen-1] == 'O'){
                board[i][yLen-1] = 'a';
                queue.add(new Point(i,yLen-1));
            }
        }
        for(int j=0;j<yLen;j++){
            if(board[0][j] == 'O'){
                board[0][j] = 'a';
                queue.add(new Point(0,j));
            }
            if(board[xLen-1][j] == 'O'){
                board[xLen-1][j] = 'a';
                queue.add(new Point(xLen-1,j));
            }
        }
        while (!queue.isEmpty()){
            Point p = queue.poll();
            int x = p.x;
            int y = p.y;
            if(x > 0 && board[x-1][y] == 'O'){
                board[x-1][y] = 'a';
                queue.add(new Point(x-1,p.y));
            }
            if(x < xLen-2 && board[x+1][y] == 'O'){
                board[x+1][y] = 'a';
                queue.add(new Point(x+1,y));
            }
            if(y>0 && board[x][y-1] == 'O'){
                board[x][y-1] = 'a';
                queue.add(new Point(x,y-1));
            }
            if(y < yLen-2 && board[x][y+1] == 'O'){
                board[x][y+1] = 'a';
                queue.add(new Point(x,y+1));
            }
        }
        for(int i=0;i<xLen;i++){
            for(int j=0;j<yLen;j++){
                if(board[i][j] == 'a'){
                    board[i][j] = 'O';
                }else{
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static class Point{
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
