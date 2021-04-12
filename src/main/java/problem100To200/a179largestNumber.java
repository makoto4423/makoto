package problem100To200;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class a179largestNumber {
    public String largestNumber(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().sorted((i, j) -> {
            String a = i.toString();
            String b = j.toString();
            String ab = a + b;
            String ba = b + a;
            return ab.compareTo(ba);
        }).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
        }
        int i = 0;
        for (; i < sb.length(); i++) {
            if (sb.charAt(i) != '0') break;
        }
        if (i == sb.length()) return "0";
        return sb.substring(i);
    }
}
