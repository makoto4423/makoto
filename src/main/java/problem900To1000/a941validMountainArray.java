package problem900To1000;

public class a941validMountainArray {
    public boolean validMountainArray(int[] A) {
        int len = A.length;
        if (len < 3) return false;
        int i = 1;
        for (; i < len; i++) {
            if (A[i] <= A[i - 1]) {
                break;
            }
        }
        if (i == 1 || i == len) return false;
        for (; i < len; i++) {
            if (A[i] >= A[i - 1]) {
                break;
            }
        }
        return i == len;
    }
}
