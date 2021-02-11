package problem700To800;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class a703KthLargest {

    List<Integer> list;
    int k;

    public a703KthLargest(int k, int[] nums) {
        list = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
        this.k = k;
    }

    public int add(int val) {
        list.add(val);
        Collections.sort(list);
        return list.get(list.size()-k);
    }
}
