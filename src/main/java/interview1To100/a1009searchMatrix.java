package interview1To100;

public class a1009searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int xLen = matrix.length;
        if(xLen == 0)   return false;
        int yLen = matrix[0].length;
        if(yLen == 0)   return false;
        for (int[] ints : matrix) {
            if (ints[0] > target) return false;
            if (ints[yLen - 1] < target) continue;
            for (int j = 0; j < yLen; j++) {
                if (ints[j] == target) return true;
            }
        }
        return false;
    }
}
