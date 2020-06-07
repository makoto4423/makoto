package problem300To400;

public class a392isSubsequence {
    public boolean isSubsequence(String s, String t) {
        int index = 0;
        for(char ch : s.toCharArray()){
            index = t.indexOf(ch,index);
            if(index < 0){
                return false;
            }
            index++;
        }
        return true;
    }
}
