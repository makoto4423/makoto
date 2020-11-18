package problem1100To1200;

import java.util.*;

public class a1122relativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int len1 = arr1.length, len2 = arr2.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len2; i++) {
            map.put(arr2[i],i);
        }
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> more = new ArrayList<>();
        for (int i = 0; i < len2; i++) {
            list.add(new ArrayList<>());
        }
        for (int i : arr1) {
            if (map.containsKey(i)) {
                list.get(map.get(i)).add(i);
            } else {
                more.add(i);
            }
        }
        Collections.sort(more);
        int[] res = new int[len1];
        int i = 0;
        for (List<Integer> l : list) {
            for (int j : l) {
                res[i++] = j;
            }
        }
        for (int j : more) {
            res[i++] = j;
        }
        return res;
    }
}
