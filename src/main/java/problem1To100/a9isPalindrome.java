package problem1To100;

public class a9isPalindrome {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i) != s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}
