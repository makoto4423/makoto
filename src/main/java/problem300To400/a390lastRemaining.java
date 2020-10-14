package problem300To400;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/elimination-game/solution/mei-ri-suan-fa-day-85-tu-jie-suan-fa-yi-xing-dai-m/
 */
@Deprecated
public class a390lastRemaining {
    public int lastRemaining(int n) {
        return n == 1 ? 1 : 2*(n/2+1-lastRemaining(n/2));
    }
//    public int lastRemaining(int n) {
//        List<Integer> list = new ArrayList<>();
//        for(int i=1;i<=n;i++){
//            list.add(i);
//        }
//        boolean asc = true;
//        while (list.size() != 1){
//            List<Integer> temp = new ArrayList<>(list);
//            if(asc){
//                for(int i=0;i<list.size();i+=2){
//                    temp.remove(list.get(i));
//                }
//                asc = false;
//            }else{
//                asc = true;
//                for(int i=list.size()-1;i>=0;i-=2){
//                    temp.remove(list.get(i));
//                }
//            }
//            list = temp;
//        }
//        return list.get(0);
//    }
}
