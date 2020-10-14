package problem900To1000;

public class a896isMonotonic {
    public boolean isMonotonic(int[] A) {
        if(A.length < 3) return true;
        int len = A.length;
        boolean asc = A[len-1] >= A[0];
        for(int i=1;i<len;i++){
            if(A[i] == A[i-1])  continue;
            if(asc){
                if(A[i] < A[i-1])   return false;
            }else{
                if(A[i] > A[i-1])   return false;
            }
        }
        return true;
    }
}
