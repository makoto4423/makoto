package problem1To100;

public class a5longestPalindrome {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0)    return "";
        int start=0, end=0;
        for(int i=0; i<s.length(); i++){
            int len1 = expandFromCenter(s, i, i);
            int len2 = expandFromCenter(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len > end-start){
                start = i-(len-1)/2;
                end = i+len/2;
            }
        }
        return s.substring(start, end+1);
    }

    public int expandFromCenter(String s, int start, int end){
        int left = start, right = end;
        while(left >= 0
                && right < s.length()
                && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }

}
