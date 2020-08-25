package match.a0823;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

//一直超時，哎
@Deprecated
public class a5497findLatestStep {
    public int findLatestStep(int[] arr, int m) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        set.add(arr.length+1);
        if(arr.length == m) return arr.length;
        for(int i=arr.length-1;i>=0;i--){
            int index = arr[i];
            int a = set.lower(index);
            int b = set.higher(index);
            if(index-a-1==m || b-index-1==m){
                return i;
            }
            set.add(index);
        }
        return -1;
    }
//    public int findLatestStep(int[] arr, int m) {
//        int[] at = new int[arr.length + 1];
//        Set<Integer> set = new HashSet<>();
//        int index = -1;
//        for (int i = 0; i < arr.length; i++) {
//            int j = arr[i];
//            if (j != arr.length) {
//                at[j] = at[j - 1] + at[j + 1] + 1;
//            } else {
//                at[j] = at[j - 1] + 1;
//            }
//            if(at[j] == m){
//                set.add(j);
//            }
//            for (int left = j - 1; left > 0; left--) {
//                if (at[left] != 0) {
//                    at[left] = at[j];
//                    set.remove(left);
//                } else {
//                    break;
//                }
//            }
//            for (int right = j + 1; right <= arr.length; right++) {
//                if (at[right] != 0) {
//                    at[right] = at[j];
//                    set.remove(right);
//                } else {
//                    break;
//                }
//            }
//            if(!set.isEmpty()){
//                index = i+1;
//            }
//        }
//        return index;
//    }
}
