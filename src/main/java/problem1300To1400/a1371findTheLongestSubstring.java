package problem1300To1400;

import java.util.Arrays;

// 想到类似于前缀和的解法，但是实在写不出来，而且单纯前缀和按照官方说法也是会超时
@Deprecated
public class a1371findTheLongestSubstring {

    public int findTheLongestSubstring(String s) {
        int n = s.length(),ans = 0,status=0;
        int[] arr = new int[32];
        Arrays.fill(arr,-1);
        arr[0] = 0;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == 'a'){
                status ^= (1);
            }else if(ch == 'e'){
                status ^= (1<<1);
            }else if(ch == 'i'){
                status ^= (1<<2);
            }else if(ch == 'o'){
                status ^= (1<<3);
            }else if(ch == 'u'){
                status ^= (1<<4);
            }
            if(arr[status]>=0){
                ans = Math.max(ans,i+1-arr[status]);
            }else{
                arr[status] = i+1;
            }
        }
        return ans;
    }

}
