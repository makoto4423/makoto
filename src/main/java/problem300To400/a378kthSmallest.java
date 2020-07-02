package problem300To400;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class a378kthSmallest {
    List<Integer> sort = new ArrayList<>();
    List<Point> pre = new ArrayList<>();
    int[][] matrix;

    public int kthSmallest(int[][] matrix, int k) {
        this.matrix = matrix;
        pre.add(new Point(0,0));
        help(k);
        return sort.get(k-1);
    }

    public void help(int k){
        if (sort.size() == k){
            return;
        }
        int min = matrix[pre.get(0).getLocation().x][pre.get(0).getLocation().y];
        Point minPoint = pre.get(0);
        int xLen = matrix.length,yLen = matrix[0].length;
        for(Point p : pre){
            if(matrix[p.getLocation().x][p.getLocation().y] < min){
                min = matrix[p.getLocation().x][p.getLocation().y];
                minPoint = p;
            }
        }
        sort.add(min);
        Point finalMinPoint = minPoint;
        pre.removeIf(p -> p.equals(finalMinPoint));
        if(finalMinPoint.getLocation().x != xLen-1){
            pre.add(new Point(finalMinPoint.getLocation().x+1,finalMinPoint.getLocation().y));
        }
        if(finalMinPoint.getLocation().y != yLen-1){
            pre.add(new Point(finalMinPoint.getLocation().x,finalMinPoint.getLocation().y+1));
        }
        help(k);
    }
}
