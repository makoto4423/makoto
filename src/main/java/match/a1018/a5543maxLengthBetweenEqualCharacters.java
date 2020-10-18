package match.a1018;

import java.util.Arrays;

public class a5543maxLengthBetweenEqualCharacters {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] arr = new int[26];
        Arrays.fill(arr,-1);
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(arr[ch-'a'] == -1){
                arr[ch-'a'] = i;
            }
        }
        int res = -1;
        for(int i=s.length()-1;i>=0;i--){
            char ch = s.charAt(i);
            if(arr[ch-'a'] != -1 && arr[ch-'a'] != i){
                res = Math.max(res,i-arr[ch-'a']-1);
            }
        }
        return res;
    }
}
