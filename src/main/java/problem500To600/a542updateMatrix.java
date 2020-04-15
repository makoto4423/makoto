package problem500To600;

// 吐槽一下，通过以后看下别人的答案，深度遍历，广度遍历，动态规划，再看看我这答案，我的算是广度遍历？连我自己都搞不清楚了
public class a542updateMatrix {
    int xLen = 0;
    int yLen = 0;
    public int[][] updateMatrix(int[][] matrix) {
        xLen = matrix.length;
        yLen = matrix[0].length;
        int[][] res = new int[xLen][yLen];
        for(int i=0; i<xLen; i++){
            for(int j=0; j<yLen; j++){
                if(matrix[i][j] != 0){
                    size : for(int size = 1; size<Integer.MAX_VALUE; size++){
                        for(int m=0; m<size+1; m++){
                            if(check(i+size-m,j+m,matrix) || check(i+size-m,j-m,matrix)
                            || check(i-size+m,j+m,matrix) || check(i-size+m,j-m,matrix)){
                                res[i][j] = size;
                                break size;
                            }
                        }
                    }

                }
            }
        }
        return  res;
    }

    public boolean check(int x, int y, int[][] matrix){
        if (x<xLen && y < yLen && x>=0 && y>=0){
            return matrix[x][y] == 0;
        }else{
            return false;
        }
    }
}
