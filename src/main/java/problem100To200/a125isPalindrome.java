package problem100To200;

public class a125isPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        for(int i=0,j=s.length()-1; i<j;){
            if(!(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') && !(s.charAt(i) >='0' && s.charAt(i) <= '9')){
                i++;continue;
            }
            if(!(s.charAt(j) >= 'a' && s.charAt(j) <= 'z') && !(s.charAt(j) >='0' && s.charAt(j) <= '9')){
                j--;continue;
            }
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
}
