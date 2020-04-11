package problem900To1000;

public class a917reverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        for(int i=0,j=S.length()-1; i<j;){
            if(help(S.charAt(i)) && help(S.charAt(j))){
                char temp = chars[i];
                chars[i] = S.charAt(j);
                chars[j] = temp;
                i++;j--;
            }else if(help(S.charAt(i))){
                j--;
            }else {
                i++;
            }
        }
        return new String(chars);
    }

    public boolean help(char ch){
        if(ch>= 'a' && 'z' >= ch)   return true;
        if(ch>='A' && 'Z'>=ch)  return true;
        return false;
    }
}
