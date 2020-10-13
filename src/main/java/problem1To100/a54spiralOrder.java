package problem1To100;

import java.util.ArrayList;
import java.util.List;

public class a54spiralOrder {
    List<Integer> list;
    int xLimit, yLimit;

    public List<Integer> spiralOrder(int[][] matrix) {
        list = new ArrayList<>();
        xLimit = matrix.length;
        if(xLimit <1)   return list;
        yLimit = matrix[0].length;
        recur(0, 0, xLimit, yLimit, matrix);
        return list;
    }

    public void recur(int xStart, int yStart, int xLen, int yLen, int[][] matrix) {
        if (xStart > (xLimit-1) / 2 || yStart > (yLimit-1) / 2) {
            return;
        }
        int i = xStart, j = yStart;
        if (j < yStart + yLen) {
            for (; j < yStart + yLen; j++) {
                list.add(matrix[i][j]);
            }
            j--;
            i++;
        }
        if (i < xStart + xLen) {
            for (; i < xStart + xLen; i++) {
                list.add(matrix[i][j]);
            }
            i--;
            j--;
        }
        if (j >= yStart && i < xStart + xLen && i >= xStart) {
            for (; j >= yStart; j--) {
                list.add(matrix[i][j]);
            }
            j++;
            i--;
        }
        if (i > xStart && j < yStart + yLen && i < xStart + xLen && j >= yStart) {
            for (; i > xStart; i--) {
                list.add(matrix[i][j]);
            }
        }

        recur(xStart + 1, yStart + 1, xLen - 2, yLen - 2, matrix);
    }
}
