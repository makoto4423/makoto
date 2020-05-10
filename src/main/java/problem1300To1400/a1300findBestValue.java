package problem1300To1400;

import java.util.Arrays;

public class a1300findBestValue {
    public int findBestValue(int[] arr, int target) {
        int res=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(target<arr[i]){
                int div = target/(arr.length-i);
                if(Math.abs(div*(arr.length-i)-target)>Math.abs((div+1)*(arr.length-i)-target)){
                    div++;
                }
                return Math.min(res,div);
            }
            target -= arr[i];
        }
        return Math.min(res,arr[arr.length-1]);
    }
}
