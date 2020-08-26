package problem300To400;

import java.util.Arrays;
import java.util.Comparator;

// 自己写的也能通过，就是 9ms 和 1820ms 差别有点大
public class a318maxProduct {
    public int maxProduct(String[] words) {
        int wlength = words.length;
        int[] arr = new int[wlength];
        for(int i = 0; i < wlength; ++i){
            int length = words[i].length();
            for(int j = 0; j < length; ++j){
                arr[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
        int ans = 0;
        for(int i = 0; i < wlength; ++i){
            for(int j = i + 1; j < wlength; ++j){
                if((arr[i] & arr[j]) == 0){
                    int k = words[i].length() * words[j].length();
                    ans = Math.max(ans, k);
                }
            }
        }
        return ans;
//        int res = 0;
//        Arrays.sort(words, Comparator.comparingInt(String::length));
//        for(int i= words.length-1;i>=0;i--){
//            String a = words[i];
//            loop : for(int j=i-1;j>=0;j--){
//                String b = words[j];
//                if(a.length()*b.length() < res){
//                    break;
//                }
//                for(char ch : b.toCharArray()){
//                    if(a.indexOf(ch) >= 0){
//                        continue loop;
//                    }
//                }
//                res = a.length()*b.length();
//            }
//        }
//        return res;
    }
}
