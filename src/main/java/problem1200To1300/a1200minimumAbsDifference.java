package problem1200To1300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a1200minimumAbsDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        int dif = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for(int i=0; i<arr.length-1; i++){
            if(dif > arr[i+1]-arr[i]){
                result = new ArrayList<>();
                dif = arr[i+1]-arr[i];
            }
            if(dif == arr[i+1]-arr[i]){
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);list.add(arr[i+1]);
                result.add(list);
            }
        }
        return result;
    }
}
