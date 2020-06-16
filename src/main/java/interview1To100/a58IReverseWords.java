package interview1To100;

public class a58IReverseWords {
    public String reverseWords(String s) {
        String[] ss = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=ss.length-1;i>=0;i--){
            if(ss[i].length() == 0) continue;
            sb.append(ss[i]).append(" ");
        }
        if(sb.length() == 0)    return "";
        return sb.toString().substring(0,sb.length()-1);
    }
}
