package problem700To800;

import java.util.LinkedList;
import java.util.Queue;

public class a733floodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int xLen = image.length;
        int yLen = image[0].length;
        int[] xx = {1,-1,0,0};
        int[] yy = {0,0,1,-1};
        int tar = image[sr][sc];
        if(tar == newColor){
            return image;
        }
        Point p = new Point(sr,sc);
        Queue<Point> queue = new LinkedList<>();
        queue.add(p);
        while (queue.size() != 0){
            Point pp = queue.poll();
            image[pp.x][pp.y] = newColor;
            for(int i =0;i<4;i++){
                int newX = pp.x+xx[i],newY = pp.y + yy[i];
                if(newX >=0 && newX < xLen && newY<yLen && newY >= 0 && image[newX][newY] == tar){
                    queue.add(new Point(newX,newY));
                }
            }
        }
        return image;
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
