package problem200To300;

// 题目重复了吧，记得有道题也是用了有序矩阵的这个特性的
public class a240searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int xLen = matrix.length;
        if(xLen < 1)    return false;
        int yLen = matrix[0].length;
        int i=0,j = yLen-1;
        while(i < xLen && j > -1){
            if(matrix[i][j] == target)  return true;
            if(matrix[i][j] > target){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
}
