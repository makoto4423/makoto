package problem900To1000;

public class a962maxWidthRamp {
    public int maxWidthRamp(int[] A) {
        int min = -1;
        if(A.length == 0 || A.length == 1)  return 0;
        for(int i=0; i<A.length; i++){
            for(int j=A.length-1; j>=i+min;j--){
                if(A[j]>=A[i]){
                    min = j-i;
                    break;
                }
            }
        }
        return min;
    }
}
