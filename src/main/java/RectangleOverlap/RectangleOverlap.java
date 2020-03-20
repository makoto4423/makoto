package RectangleOverlap;

public class RectangleOverlap {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int[] leftBottom = {rec1[0], rec1[1]};
        int[] leftHigh = {rec1[0],rec1[3]};
        int[] rightBottom = {rec1[2],rec1[1]};
        int[] rightHigh = {rec1[2],rec1[3]};
        return in(leftBottom,rec2) || in(leftHigh,rec2)|| in(rightBottom,rec2)|| in(rightHigh,rec2);

    }

    public boolean in(int[] node, int[] rec2){
        int xa = rec2[0];
        int xb = rec2[2];
        int ya = rec2[1];
        int yb = rec2[3];
        return (xb >= node[0] && node[0] >= xa && node[1] >= ya && yb >= node[1]);
    }


}
