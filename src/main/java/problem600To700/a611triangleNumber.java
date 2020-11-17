package problem600To700;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Deprecated
public class a611triangleNumber {

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int count = 0, k;
        if (len < 3) return 0;
        for (int i = 0; i < len; i++) {
            k = i + 2;
            for (int j = i + 1; j < len && nums[i] != 0; j++) {
                k = binarySearch(nums, k, len-1, nums[i] + nums[j]);
                count += k - j - 1;
            }
        }
        return count;
    }

    public int binarySearch(int[] num, int l, int r, int x) {
        while (r >= l && r < num.length) {
            int mid = (r - l) / 2 + l;
            if (num[mid] >= x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

//    int res, len;
//    int[] num;
//
//    public int triangleNumber(int[] nums) {
//        res = 0;
//        num = nums;
//        len = num.length;
//        Arrays.sort(num);
//        if (len < 3) return res;
//        recur(0, new ArrayList<>());
//        return res;
//    }
//
//    public boolean recur(int i, List<Integer> list) {
//        if (list.size() == 3) {
//            int a = list.get(0), b = list.get(1), c = list.get(2);
//            if (a + b > c) {
//                res++;
//                return true;
//            }
//            return false;
//        }
//        for (int m = i; m < len; m++) {
//            list.add(num[m]);
//            if(!recur(m + 1, list)){
//                list.remove(list.size() - 1);
//                break;
//            }else{
//                list.remove(list.size() - 1);
//            }
//        }
//        return true;
//    }

}
