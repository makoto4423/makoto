package problem200To300;

import java.util.ArrayList;
import java.util.List;

public class a228summaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i != nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
                int j = i + 1;
                for (; j < nums.length-1; j++) {
                    if (nums[j] + 1 != nums[j+1]) break;
                }
                list.add(nums[i] + "->" + nums[j]);
                i = j;
            } else {
                list.add(nums[i] + "");
            }
        }
        return list;
    }
}
