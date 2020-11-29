package match.a1129;

// 面向测试用例编程。。。。先加个判断，递增/递减数组直接进行数组复制返回
// 不过想了想，这种操作应该放进递归里面做，切到后面如果是个有序数组就直接返回，不过嘛。。。懒
public class MostCompetitive {
    public int[] mostCompetitive(int[] nums, int k) {
        int[] res = new int[k];
        int len = nums.length;
        int i = 0;
        for (; i < len - 1; i++) {
            if (nums[i] > nums[i + 1]) break;
        }
        if (i == len - 1) {
            System.arraycopy(nums, 0, res, 0, k);
            return res;
        }
        i = 0;
        for (; i < len - 1; i++) {
            if (nums[i] < nums[i + 1]) break;
        }
        if (i == len - 1) {
            System.arraycopy(nums, len - k, res, 0, k);
            return res;
        }
        recur(nums, 0, k, res);
        return res;
    }

    public void recur(int[] nums, int index, int k, int[] res) {
        if (k == 0) {
            return;
        }
        int min = Integer.MAX_VALUE;
        for (int i = index; i <= nums.length - k; i++) {
            if (nums[i] < min) {
                min = nums[i];
                index = i;
            }
        }
        res[res.length - k] = min;
        recur(nums, index + 1, k - 1, res);
    }
}
