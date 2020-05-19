package problem600To700;

public class a680validPalindrome {

    public boolean validPalindrome(String s) {
        int i=0,j=s.length()-1;
        boolean tag = true;
        for(;i<j;i++,j--){
            if(s.charAt(i)!=s.charAt(j)){
                tag = false;
                break;
            }
        }
        if(tag) return true;
        tag = true;
        for(int m=i+1,n=j;m<n;m++,n--){
            if(s.charAt(m)!=s.charAt(n)){
                tag = false;
                break;
            }
        }
        if(tag) return true;
        tag = true;
        for(int m=i,n=j-1;m<n;m++,n--){
            if(s.charAt(m)!=s.charAt(n)){
                tag =false;
                break;
            }
        }
        return tag;
    }

}
