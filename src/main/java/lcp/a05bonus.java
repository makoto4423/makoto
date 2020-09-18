package lcp;

import java.util.*;

public class a05bonus {
    public int[] bonus(int n, int[][] leadership, int[][] operations) {
        Map<Integer,Integer> stat = new HashMap<>();
        Map<Integer, List<Integer>> childMap = new HashMap<>();
        for (int[] a : leadership) {
            stat.put(a[0],stat.getOrDefault(a[0],0)+1);
            List<Integer> father = childMap.getOrDefault(a[1], new ArrayList<>());
            father.add(a[0]);
            childMap.put(a[1], father);
        }
        for(int i=1;i<n+1;i++){
            if(!stat.containsKey(i)) stat.put(i,0);
        }
        int[] arr = new int[n + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        boolean flag = true;
        while (flag) {
            flag = false;
            Iterator<Integer> iterator = stat.keySet().iterator();
            while(iterator.hasNext()){
                Integer i = iterator.next();
                if (stat.get(i) == 0 && childMap.containsKey(i)) {
                    List<Integer> father = childMap.get(i);
                    for (Integer j : father) {
                        List<Integer> mem = map.getOrDefault(j, new ArrayList<>());
                        mem.add(i);
                        mem.addAll(map.getOrDefault(i,new ArrayList<>()));
                        map.put(j, mem);
                        stat.put(j,stat.get(j)-1);
                        if (stat.get(j) == 0) flag = true;
                    }
                    iterator.remove();
                    childMap.remove(i);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int[] opera : operations) {
            int index = opera[1];
            if (opera[0] == 1) {
                arr[index] = (arr[index] % 1000000007 + opera[2] % 1000000007) % 1000000007;
            } else if (opera[0] == 2) {
                int value = opera[2] % 1000000007;
                arr[index] = (arr[index] % 1000000007 + value) % 1000000007;
                List<Integer> List = map.getOrDefault(index, new ArrayList<>());
                for (Integer i : List) {
                    arr[i] = (arr[i] % 1000000007 + value) % 1000000007;
                }
            } else {
                int value = arr[index];
                List<Integer> List = map.getOrDefault(index, new ArrayList<>());
                for (Integer i : List) {
                    value = (value + arr[i] % 1000000007) % 1000000007;
                }
                res.add(value);
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
