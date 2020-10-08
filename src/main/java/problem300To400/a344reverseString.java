package problem300To400;

/**
 * 6个月前通过了，现在不通过。。。
 */
public class a344reverseString {
    public void reverseString(char[] s) {
        for(int i=0; i<=s.length/2-1; i++){
            char temp = s[i];
            s[i] = s[s.length-i-1];
            s[s.length-i-1] = temp;
        }
    }
}
