package match;

public class a5483makeGood {
    public String makeGood(String s) {
        if(s.length() < 2)  return s;
        boolean b = true;
        while (b){
            b = false;
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<s.length();i++){
                if(i == s.length()-1){
                    sb.append(s.charAt(i));
                }else if(Math.abs(s.charAt(i)-s.charAt(i+1)) == 32){
                    i++;
                    b = true;
                }else{
                    sb.append(s.charAt(i));
                }
            }
            s = sb.toString();
        }
        return s;
    }
}
