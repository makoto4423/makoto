package offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class a38permutation {
    String s;
    Set<String> res;
    public String[] permutation(String s) {
        this.s = s;
        res = new HashSet<>();
        recur("",new boolean[s.length()],0);
        return res.toArray(new String[res.size()]);
    }

    public void recur(String temp,boolean[] visited,int pos){
        if(temp.length() == s.length()){
            res.add(temp);
            return;
        }
        for(int i=pos;i<s.length()+pos;i++){
            if(!visited[i%s.length()]){
                visited[i%s.length()] = true;
                recur(temp+s.charAt(i%s.length()),visited,i+1);
                visited[i%s.length()] = false;
            }
        }
    }
}
