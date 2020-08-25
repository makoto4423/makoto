package problem400To500;

public class a459repeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        for(int i=1;i<=s.length()/2;i++){
            if(s.length()%i != 0){
                continue;
            }
            String ss = s.substring(0,i);
            int repeat = s.length()/i;
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<repeat;j++){
                sb.append(ss);
            }
            if(sb.toString().equals(s)) return true;
        }
        return false;
    }
}
