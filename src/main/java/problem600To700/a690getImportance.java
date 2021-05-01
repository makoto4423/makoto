package problem600To700;

import struct.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a690getImportance {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Integer> value = new HashMap<>();
        Map<Integer, List<Integer>> sub = new HashMap<>();
        for (Employee e : employees) {
            value.put(e.id, e.importance);
            sub.put(e.id, e.subordinates);
        }
        return getImportance(value, sub, id);
    }

    public int getImportance(Map<Integer, Integer> value, Map<Integer, List<Integer>> sub, int id) {
        int v = value.get(id);
        List<Integer> subs = sub.get(id);
        if (subs != null) {
            for (Integer s : subs) {
                v += getImportance(value, sub, s);
            }
        }
        return v;
    }
}
