package problem300To400;

import java.util.Arrays;

public class a303NumArray {

    int[] num;

    public a303NumArray(int[] nums) {
        this.num = nums;
    }

    public int sumRange(int i, int j) {
        int res = 0;
        for (int k = i; k <= j; k++) {
            res += num[k];
        }
        return res;
    }
}
