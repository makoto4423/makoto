package problem1000To1100;

import java.util.ArrayList;
import java.util.List;

public class a1053prevPermOpt1 {
    public int[] prevPermOpt1(int[] A) {
        int len = A.length;
        List<Integer> list = new ArrayList<>();
        int i=len-1;
        int j = 0;
        all : for(;i>=0;i--){
            j = list.size()-1;
            for(;j>=0;j--){
                if(list.get(j) < A[i])  break all;
            }
            list.add(0,A[i]);
        }
        if(j != -1){
            for(int m = i+1;m<len;m++){
                if(A[m] == list.get(j)){
                    A[i] += A[m];
                    A[m] = A[i]-A[m];
                    A[i] -= A[m];
                    break;
                }
            }
        }
        return A;
    }
}
