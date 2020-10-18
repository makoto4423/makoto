package match.a1011;

public class a5537checkPalindromeFormation {
    public boolean checkPalindromeFormation(String a, String b) {
        int i=0,len = a.length();
        for(;i<len/2;i++){
            if(a.charAt(i) != b.charAt(len-i-1)){
                break;
            }
        }
        StringBuilder sb = new StringBuilder(a.substring(0,i)+b.substring(i));
        if(isPalindrome(sb.toString())){
            return true;
        }
        sb = new StringBuilder(a.substring(0,len-i)+b.substring(len-i));
        if(isPalindrome(sb.toString())){
            return true;
        }
        i=0;
        for(;i<len/2;i++){
            if(b.charAt(i) != a.charAt(len-i-1)){
                break;
            }
        }
        sb = new StringBuilder(b.substring(0,i)+a.substring(i));
        if(isPalindrome(sb.toString())){
            return true;
        }
        sb = new StringBuilder(b.substring(0,len-i)+a.substring(len-i));
        return isPalindrome(sb.toString());
    }

    public boolean isPalindrome(String s){
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i) != s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}
