package problem500To600;

public class a566matrixReshape {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if (m * n != r * c) return nums;
        int[][] res = new int[r][c];
        int x = 0, y = 0;
        for (int[] arr : nums) {
            for (int i : arr) {
                res[x][y] = i;
                if (y == c - 1) {
                    x++;
                    y = 0;
                } else {
                    y++;
                }
            }
        }
        return res;
    }
}
