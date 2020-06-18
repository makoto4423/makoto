package problem500To600;

public class a541reverseStr {
    public String reverseStr(String s, int k) {
        if(k <=0 )  return s;
        StringBuilder res = new StringBuilder();
        for(int i=0;i<s.length();i=i+2*k){
            int len = s.length()-i >= k ? i+k : s.length();
            StringBuilder sb = new StringBuilder(s.substring(i,len));
            res.append(sb.reverse());
            int end = s.length()-len>=k ? len+k : s.length();
            res.append(s,len,end);
        }
        return res.toString();
    }
}
