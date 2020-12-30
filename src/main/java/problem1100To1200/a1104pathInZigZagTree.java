package problem1100To1200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class a1104pathInZigZagTree {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new ArrayList<>();
        if (label == 1) {
            res.add(1);
            return res;
        }
        int depth = (int) Math.ceil(Math.log(label + 1) / Math.log(2));
        int left = -1;
        if (depth % 2 == 0) {
            int line = (int) Math.pow(2, depth) - 1;
            left = line - label;
        } else {
            int line = (int) Math.pow(2, depth - 1);
            left = label - line;
        }
        res.add(label);
        depth--;
        left /= 2;
        while (depth > 0) {
            if (depth % 2 == 0) {
                res.add((int) (Math.pow(2, depth) - 1 - left));
            } else {
                res.add((int) Math.pow(2, depth - 1) + left);
            }
            depth--;
            left /= 2;
        }
        Collections.reverse(res);
        return res;
    }
}
