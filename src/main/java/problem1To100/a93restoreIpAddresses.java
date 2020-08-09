package problem1To100;

import java.util.ArrayList;
import java.util.List;

public class a93restoreIpAddresses {
    List<String> res;
    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        dp(s,new StringBuilder(), 0, 0);
        return res;
    }

    public void dp(String s, StringBuilder temp, int index,int num){
        if(num == 4){
            if(index == s.length()){
                res.add(temp.substring(0,temp.length()-1).toString());
            }
        }else{
            for(int i=index+1;i<=s.length()&&i<=index+3;i++){
                int a = Integer.parseInt(s.substring(index,i));
                if(a<=255 && i-index == (a+"").length()){
                    StringBuilder t = new StringBuilder(temp);
                    t.append(a).append(".");
                    dp(s, t, i, num+1);
                }
            }
        }
    }
}
