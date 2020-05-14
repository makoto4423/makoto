package problem1200To1300;

import java.util.List;

//
@Deprecated
public class a1239maxLength {
    public int dfs(List<String> arr,int index, int flag){
        if(index>=arr.size()){
            return 0;
        }
        int max = 0;
        for(int i=index;i<arr.size();i++){
             String s = arr.get(i);
             int f=0;
             for(char ch: s.toCharArray()){
                 if((f&(1 << (ch-'a'))) != 0){
                     f = 0;
                     break;
                 }
                 f |= (1 << ch-'a');
             }
             if(f == 0 || (flag & f) != 0)  continue;
             max = Math.max(max,s.length()+dfs(arr,i+1,flag|f));
        }
        return max;
    }
    public int maxLength(List<String> arr) {
        return dfs(arr,0,0);
    }
}
