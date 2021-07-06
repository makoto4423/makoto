package problem1400To1500;

import java.util.*;
import java.util.stream.Collectors;

// 神似日常写的业务代码
public class a1418displayTable {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<String, Map<Integer, Integer>> food = new HashMap<>();
        Set<Integer> tableSet = new HashSet<>();
        Set<String> foodSet = new HashSet<>();
        for (List<String> order : orders) {
            Map<Integer, Integer> table = food.computeIfAbsent(order.get(2), k -> new HashMap<>());
            Integer tn = Integer.parseInt(order.get(1));
            table.put(tn, table.getOrDefault(tn, 0) + 1);
            tableSet.add(tn);
            foodSet.add(order.get(2));
        }
        List<String> fl = foodSet.stream().sorted().collect(Collectors.toList());
        List<Integer> tl = tableSet.stream().sorted().collect(Collectors.toList());
        List<List<String>> res = new ArrayList<>();
        List<String> head = new ArrayList<>();
        head.add("Table");
        head.addAll(fl);
        res.add(head);
        for (Integer tn : tl) {
            List<String> data = new ArrayList<>();
            data.add(tn.toString());
            for (String f : fl) {
                Map<Integer,Integer> table = food.get(f);
                data.add((table.getOrDefault(tn, 0)) + "");
            }
            res.add(data);
        }
        return res;
    }
}
