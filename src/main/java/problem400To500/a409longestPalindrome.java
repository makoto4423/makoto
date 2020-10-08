package problem400To500;

public class a409longestPalindrome {
    public int longestPalindrome(String s) {
        int[] arr = new int[58];
        for(char ch : s.toCharArray()){
            arr[ch-'A']++;
        }
        int len = 0;
        for(int i : arr){
            len += (i/2)*2;
        }
        if(len!=s.length()){
            len++;
        }
        return len;
    }
}
