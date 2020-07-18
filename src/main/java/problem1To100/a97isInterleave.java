package problem1To100;

// 这是hard？看了3分钟就想出解法
public class a97isInterleave {
    String sub1,sub2,s;
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        this.sub1 = s1;
        this.sub2 = s2;
        this.s = s3;
        return recur(0,0,0);
    }

    public boolean recur(int pos1,int pos2, int pos){
        if(pos == s.length()){
            return true;
        }
        if(pos1 < sub1.length() && sub1.charAt(pos1) == s.charAt(pos)){
            if(recur(pos1+1,pos2, pos+1)){
                return true;
            }
        }
        if(pos2 < sub2.length() && sub2.charAt(pos2) == s.charAt(pos)){
            return recur(pos1, pos2 + 1, pos + 1);
        }
        return false;
    }
}
