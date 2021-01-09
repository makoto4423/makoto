package problem300To400;

import java.util.*;
import java.util.function.Function;

// 写了一堆，发现好复杂啊，放弃，看答案，还是好复杂
@Deprecated
public class a399calcEquation {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int line = 0;
        // 边排号
        Map<String, Integer> weights = new HashMap<>();
        for (List<String> equ : equations) {
            if (!weights.containsKey(equ.get(0))) {
                weights.put(equ.get(0), line++);
            }
            if (!weights.containsKey(equ.get(1))) {
                weights.put(equ.get(1), line++);
            }
        }
        // 边赋权
        List<Pair>[] edge = new List[line];
        // Arrays.fill(Object[] a, Object val)
        // 这个方法有坑，val对象它不会重新构建，所以a数组内公用一个对象
        // Arrays.fill(edge,new ArrayList<>());
        for(int i=0;i<line;i++){
            edge[i] = new ArrayList<>();
        }
        for (int i = 0; i < values.length; i++) {
            int a = weights.get(equations.get(i).get(0)), b = weights.get(equations.get(i).get(1));
            edge[a].add(new Pair(b, values[i]));
            edge[b].add(new Pair(a, 1.0 / values[i]));
        }
        double[] res = new double[queries.size()];
        int index = 0;
        for (List<String> query : queries) {
            double value = -1.0;
            if (weights.containsKey(query.get(0)) && weights.containsKey(query.get(1))) {
                int a = weights.get(query.get(0)), b = weights.get(query.get(1));
                if (a == b) {
                    value = 1.0;
                } else {
                    double[] arr = new double[line];
                    Arrays.fill(arr, -1.0);
                    arr[a] = 1.0;
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(a);
                    while (!queue.isEmpty() && arr[b] < 0) {
                        int x = queue.poll();
                        for (Pair p : edge[x]) {
                            int y = p.index;
                            if(arr[y] < 0){
                                arr[y] = arr[x]*p.dou;
                                queue.offer(y);
                            }
                        }
                    }
                    value = arr[b];
                }
            }
            res[index++] = value;
        }
        return res;

    }

    static class Pair {
        public int index;
        public double dou;

        public Pair(int index, double dou) {
            this.index = index;
            this.dou = dou;
        }
    }

//    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
//        Map<String, Body> map = new HashMap<>();
//        for (int i = 0; i < values.length; i++) {
//            List<String> equ = filter(equations.get(i));
//            String a = equ.get(0), b = equ.get(1);
//            Body aBody = map.computeIfAbsent(a,key->new Body());
//            Body bBody = map.computeIfAbsent(b,key->new Body());
//            aBody.str.add(b);
//            aBody.dou.add(values[i]);
//            for(int j=0;j<bBody.str.size();j++){
//                aBody.str.add(bBody.str.get(j));
//                aBody.dou.add(bBody.dou.get(j)*values[i]);
//            }
//        }
//
//    }
//
//    public List<String> filter(List<String> list) {
//        String a = list.get(0), b = list.get(1);
//        int[] c1 = new int[26], c2 = new int[26];
//        for (char ch : a.toCharArray()) {
//            c1[ch - 'a']++;
//        }
//        for (char ch : b.toCharArray()) {
//            c2[ch - 'a']++;
//        }
//        for (int i = 0; i < 26; i++) {
//            int temp = Math.min(c1[i], c2[i]);
//            c1[i] -= temp;
//            c2[i] -= temp;
//        }
//        StringBuilder s1 = new StringBuilder();
//        StringBuilder s2 = new StringBuilder();
//        for (int i = 0; i < 26; i++) {
//            while (c1[i] > 0) {
//                s1.append((char) (c1[i] + 'a'));
//                c1[i]--;
//            }
//            while (c2[i] > 0) {
//                s2.append((char) (c2[i] + 'a'));
//                c2[i]--;
//            }
//        }
//        return Arrays.asList(s1.toString(), s2.toString());
//    }
//
//    static class Body{
//        public List<String> str;
//        public List<Double> dou;
//    }
}
