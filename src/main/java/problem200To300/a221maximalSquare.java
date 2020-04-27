package problem200To300;

import java.util.Map;
// 都不记得是第几次写这种题了
public class a221maximalSquare {
    int xLen;
    int yLen;
    char[][] mat;
    int max=0;
    public int maximalSquare(char[][] matrix) {
        mat = matrix;
        xLen = matrix.length;
        if(xLen == 0) return 0;
        yLen = matrix[0].length;
        for(int i=0; i<xLen; i++){
            for(int j=0; j<yLen; j++){
                if(matrix[i][j] == '1'){
                    int size = visit(i,j,1);
                    max = Math.max(max,(size+1)*(size+1));
                }
            }
        }
        return max;
    }

    public int visit(int i, int j, int size){
        if(i+size>=xLen || j+size>=yLen)  return size-1;
        for(int m=0;m<=size;m++){
            if(mat[i+m][j+size] != '1'){
                return size-1;
            }
        }
        for(int m=0;m<=size;m++){
            if(mat[i+size][j+m] != '1'){
                return size-1;
            }
        }
        return visit(i,j,size+1);
    }
}
