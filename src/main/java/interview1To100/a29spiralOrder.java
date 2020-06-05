package interview1To100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class a29spiralOrder {
    public int[]  spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int xLen = matrix.length;
        if(xLen == 0)   return new int[]{};
        int yLen = matrix[0].length;
        int i=0,j=0,a=0;
        while(a<=xLen/2 && a<=yLen/2){
            if(j<yLen-a && i<xLen-a &&j>=a && i>=a){
                while(j<yLen-a){
                    res.add(matrix[i][j]);
                    j++;
                }
                j--;i++;
            }
            if(j<yLen-a && i<xLen-a &&j>=a && i>=a){
                while(i<xLen-a){
                    res.add(matrix[i][j]);
                    i++;
                }
                i--;j--;
            }
            if(j<yLen-a && i<xLen-a &&j>=a && i>=a){
                while(j>=a){
                    res.add(matrix[i][j]);
                    j--;
                }
                j++;i--;
            }
            if(j<yLen-a && i<xLen-a &&j>=a && i>=a){
                while(i>=1+a){
                    res.add(matrix[i][j]);
                    i--;
                }
                i++;j++;
            }
            a++;
        }
        int[] b = new int[res.size()];
        for(i=0;i <res.size();i++){
            b[i] = res.get(i);
        }
        return b;
    }
}
