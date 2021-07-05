package problem700To800;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

// 栈，虽说是困难，但纯粹是考虑耐心
public class a726countOfAtoms {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        StringBuilder pre = new StringBuilder();
        int preCount = 0;
        Map<String, Integer> now = new HashMap<>();
        for (int i = 0; i < formula.length(); i++) {
            char ch = formula.charAt(i);
            if (ch == '(') {
                if (preCount != 0) {
                    now.put(pre.toString(), now.getOrDefault(pre.toString(), 0) + preCount);
                    pre = new StringBuilder();
                    preCount = 0;
                }
                stack.push(now);
                now = new HashMap<>();
            } else if (ch == ')') {
                if (preCount != 0) {
                    now.put(pre.toString(), now.getOrDefault(pre.toString(), 0) + preCount);
                    pre = new StringBuilder();
                    preCount = 0;
                }
                Map<String, Integer> preMap = stack.pop();
                int nowCount = 1;
                if (i != formula.length() - 1 && formula.charAt(i + 1) <= '9' && formula.charAt(i + 1) >= '0') {
                    int j = i + 1;
                    for (; j < formula.length(); j++) {
                        if (formula.charAt(j) > '9' || formula.charAt(j) < '0') break;
                    }
                    nowCount = Integer.parseInt(formula.substring(i + 1, j));
                    i = j - 1;
                }
                for (String k : now.keySet()) {
                    now.put(k, now.get(k) * nowCount);
                }
                if (!preMap.isEmpty()) {
                    now.forEach((k, v) -> preMap.put(k, preMap.getOrDefault(k, 0) + v));
                    now = preMap;
                }
            } else if (ch <= 'Z' && ch >= 'A') {
                if (preCount != 0) {
                    now.put(pre.toString(), now.getOrDefault(pre.toString(), 0) + preCount);
                }
                pre = new StringBuilder(ch + "");
                preCount = 1;
            } else if (ch <= 'z' && ch >= 'a') {
                pre.append(ch);
            } else {
                int j = i;
                for (; j < formula.length(); j++) {
                    if (formula.charAt(j) > '9' || formula.charAt(j) < '0') break;
                }
                preCount = Integer.parseInt(formula.substring(i, j));
                i = j - 1;
            }
        }
        if (preCount != 0) {
            now.put(pre.toString(), now.getOrDefault(pre.toString(), 0) + preCount);
        }
        List<String> key = now.keySet().stream().sorted().collect(Collectors.toList());
        StringBuilder res = new StringBuilder();
        for (String k : key) {
            res.append(k);
            if (now.get(k) != 1) {
                res.append(now.get(k));
            }
        }
        return res.toString();
    }
}
