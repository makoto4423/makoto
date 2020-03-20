public class isPalindrome {

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        for(int i=0,j=s.length()-1; i<s.length() && j>0;){
            if(!(s.charAt(i)>= '0' && '9'>=s.charAt(i)) && !(s.charAt(i)>='a'&& 'z'>=s.charAt(i))){
                i++;continue;
            }
            if(!(s.charAt(j)>= '0' && '9'>=s.charAt(j)) && !(s.charAt(j)>='a'&& 'z'>=s.charAt(j))){
                j--;continue;
            }
            if(s.charAt(i) != s.charAt(j))  return false;
            else {
                i++;j--;
            }
        }
        return true;
    }
}
