package problem900To1000;

import java.util.Arrays;

/**
 * @see a945minIncrementForUnique1
 * 20200324创建的代码，超时无从下手
 * 20210323看了两眼加了个排序就过了
 */
public class a945minIncrementForUnique {
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int res = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] >= A[i + 1]) {
                res += A[i] - A[i + 1] + 1;
                A[i + 1] = A[i] + 1;
            }
        }
        return res;
    }
}
