public class isRectangleOverlap {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int[] left;
        int[] right;
        if(rec2[0] >= rec1[0]){
            left = rec1;right=rec2;
        }else {
            left = rec2;right=rec1;
        }
        if(right[0] >= left[2])  return false;
        if(left[1] > right[1]){
            return right[3]>left[1];
        }else {
            return left[3]>right[1];
        }
    }

}
