package problem500To600;

public class a557reverseWords {

    public String reverseWords(String s) {
        String[] ss = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String a : ss){
            StringBuilder as = new StringBuilder(a);
            sb.append(as.reverse()).append(" ");
        }
        if(sb.length() == 0)    return "";
        return sb.substring(0,sb.length()-1);
    }
}
