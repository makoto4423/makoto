package problem1To100;

public class a58lengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] ss = s.split(" ");
        if(ss.length < 1){
            return 0;
        }else{
            return ss[ss.length-1].length();
        }
    }
}
