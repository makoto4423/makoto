package problem900To1000;

public class a926minFlipsMonoIncr {
    public int minFlipsMonoIncr(String S) {
        if(S.length() == 0 || S.length() == 1)  return 0;
        int j = S.length()-1;
        for(;j>=0; j--){
            if(S.charAt(j) == '0') break;
        }
        String s;
        if(j == S.length()-1){
            s = S;
        }else{
            s = S.substring(0,j+1);
        }
        int zCnt = 0,oCnt = 0,cnt = 0;
        for(int i=0; i<s.length(); i++){
            j = s.charAt(i) == '1' ? 1 : 0;
            if(j == 0 && oCnt == 0){
                zCnt = 0;
            }else if(j == 1){
                oCnt++;
            }else {
                zCnt++;
            }
            if(zCnt >= oCnt){
                cnt += oCnt;
                oCnt = 0;
                zCnt = 0;
            }
        }
        return cnt + Math.min(oCnt,zCnt);
    }
}
