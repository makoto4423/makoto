package problem800To900;

import java.util.Arrays;

public class a845longestMountain {
    public int longestMountain(int[] A) {
        int len = A.length;
        if(len < 3) return 0;
        char[] arr = new char[len];
        Arrays.fill(arr,'-');
        arr[0] = 'd';arr[len-1] = 'd';
        for(int i=1;i<len-1;i++){
            if(A[i] == A[i-1] || A[i] == A[i+1]){
                arr[i] = 'd';
            }else if(A[i] > A[i-1] && A[i] > A[i+1]){
                arr[i] = 'u';
            }else if(A[i] < A[i-1] && A[i] < A[i+1]){
                arr[i] = 'd';
            }
        }
        int res = 0;
        for(int i=0;i<len;i++){
            if(arr[i] == 'd'){
                loop: for(int j=i+1;j<len;j++){
                    if(arr[j] == 'u'){
                        for(int k=j+1;k<len;k++){
                            if(arr[k] == 'd'){
                                res = Math.max(k-i+1,res);
                                break loop;
                            }else if(arr[k] != '-'){
                                break loop;
                            }
                        }
                    }else if(arr[j] != '-'){
                        break;
                    }
                }
            }
        }
        return res;
    }
}
