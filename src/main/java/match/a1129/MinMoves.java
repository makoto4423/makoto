package match.a1129;

import java.util.*;


/**
 * 对于一个数对[a,b]，令min = Math.min(a,b) max = Math.max(a,b);一定有1 <= min <= max <= limit,为了方便理解，我们考虑这种简单的情况，1 < min < max < limit,那么数对[a,b]能取到的值的情况以及需要的操作次数为：
 * 2 ~ min : 2次
 * min + 1 ~ min + max - 1 : 1次
 * min + max : 0次
 * min + max + 1 ~ max + limit : 1次
 * max + limit + 1 ~ 2 * limit ：2次
 *
 * 然后就是差分数组
 */
@Deprecated
public class MinMoves {
    public int minMoves(int[] nums, int limit) {
        int[] dif = new int[2 * limit + 2];
        for (int i = 0; i < nums.length / 2; i++) {
            int min = Math.min(nums[i], nums[nums.length - i - 1]);
            int max = Math.max(nums[i], nums[nums.length - i - 1]);
            // 每个数组对，次数都是2 - 1 - 0 - 1 - 2
            // 所以就出现 +2,-1,-1,+1,+1
            dif[1] += 2;
            dif[min + 1] -= 1;
            dif[min + max] -= 1;
            dif[min + max + 1] += 1;
            dif[max + limit + 1] += 1;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < dif.length; i++) {
            dif[i] += dif[i - 1];
            res = Math.min(dif[i], res);
        }
        return res;
    }
}
