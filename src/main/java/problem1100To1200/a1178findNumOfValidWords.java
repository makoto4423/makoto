package problem1100To1200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 二进制状态压缩
@Deprecated
public class a1178findNumOfValidWords {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (String w : words) {
            int temp = 0;
            for (char ch : w.toCharArray()) {
                temp |= (1 << ch - 'a');
            }
            if (Integer.bitCount(temp) < 8) {
                freq.put(temp, freq.getOrDefault(temp, 0) + 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (String p : puzzles) {
            int mask = 0;
//            for (char ch : p.toCharArray()) {
//                mask |= (1 << ch - 'a');
//            }
            // 这里必须要排除掉第零位，否则会统计两遍
            // 枚举二进制子集时，第零位的取值为0和1都属于子集中，但是题目明确只要取值为1的
            // 故，需要排除，否则统计的时候会统计两遍
            for (int i = 1; i < 7; i++) {
                mask |= (1 << p.charAt(i) - 'a');
            }
            int temp = 0;
            /*
             *  枚举二进制子集 通用写法
             *  int sub = mask;
             *  do{
             *      sub = (sub - 1) & mask;
             *  }while (sub != mask);
             *
             */
            int sub = mask;
            do {
                int s = sub | (1 << p.charAt(0) - 'a');
                temp += freq.getOrDefault(s, 0);
                sub = (sub - 1) & mask;
            } while (sub != mask);
            res.add(temp);
        }
        return res;
    }
}
