package problem1To100;

// dp问题，然而我还是写成递归
public class a91numDecodings {
    int cnt = 0;
    public int numDecodings(String s) {
        help(s,0);
        return cnt;
    }

    public void help(String s,int index){
        if(index > s.length())  return;
        if(index == s.length()){
            cnt++;
            return ;
        }
        if(s.charAt(index) == '0')  return;
        if(index == s.length()-1){
            cnt++;
            return;
        }
        if(s.charAt(index) == '1' || (s.charAt(index)=='2' && s.charAt(index+1) < '7')){
            help(s,index+2);
        }
        help(s,index+1);
    }
}
