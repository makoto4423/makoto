package match.a0823;

import java.util.ArrayList;
import java.util.List;

public class a5495mostVisited {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] arr = new int[n+1];
        arr[rounds[0]]++;
        for(int i=0;i<rounds.length-1;i++){
            if(rounds[i+1] > rounds[i]){
                for(int j=rounds[i]+1;j<=rounds[i+1];j++){
                    arr[j]++;
                }
            }else{
                for(int j=rounds[i]+1;j<n+1;j++){
                    arr[j]++;
                }
                for(int j=1;j<=rounds[i+1];j++){
                    arr[j]++;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        int max = 0;
        for(int i : arr){
            max = Math.max(i,max);
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i] == max){
                list.add(i);
            }
        }
        return list;
    }
}
