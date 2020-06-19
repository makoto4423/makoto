package problem200To300;

import java.util.*;
// 算是做出来还是没做出来呢？偷看了答案的字眼“拓扑”，上网查了拓扑再手写出来。。。
@Deprecated
public class a207canFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,Set<Integer>> pre = new HashMap<>();
        Set<Integer> noParent = new HashSet<>();
        int amount = 0;
        for(int i=0;i<numCourses;i++){
            pre.put(i,new HashSet<>());
        }
        for(int[] prereq : prerequisites){
            Set<Integer> p = pre.get(prereq[0]);
            p.add(prereq[1]);
        }
        for(int i=0;i<numCourses;i++){
            Set<Integer> p = pre.get(i);
            if(p.size() == 0){
                noParent.add(i);
                pre.put(i,null);
            }
        }
        amount = noParent.size();
        boolean update = true;
        while (update){
            Set<Integer> n = new HashSet<>();
            update = false;
            for(int i=0;i<numCourses;i++){
                Set<Integer> p = pre.get(i);
                if(p == null) continue;
                for(Integer a : noParent){
                    p.remove(a);
                }
                if(p.size() == 0 && !noParent.contains(i) && !n.contains(i)){
                    pre.put(i,null);
                    n.add(i);
                    update = true;
                    amount++;
                }
            }
            noParent = n;
        }
        return amount == numCourses;
    }
}
