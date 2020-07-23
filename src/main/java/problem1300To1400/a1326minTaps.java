package problem1300To1400;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class a1326minTaps {
    public int minTaps(int n, int[] ranges) {
        List<Point> point = new ArrayList<>();
        for(int i=0;i<ranges.length;i++){
            Point p = new Point();
            p.setLeft(i-ranges[i]);
            p.setRight(i+ranges[i]);
            point.add(p);
        }
        int left = 0,right = 0,amount = 0;
        while (left < n){
            for(Point p : point){
                if(p.left <= left){
                    right = Math.max(right, p.right);
                }
            }
            if(left >= right){
                return -1;
            }
            amount++;
            left = right;
        }
        return amount;
    }

    public static class Point{
        int left, right;

        public int getLeft() {
            return left;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public int getRight() {
            return right;
        }

        public void setRight(int right) {
            this.right = right;
        }
    }
}
