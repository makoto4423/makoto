package problem1To100;

public class a8myAtoi {
    public int myAtoi(String str) {
        StringBuilder sb = new StringBuilder();
        boolean isStart = false;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '0'){
                isStart = true;
                if(sb.length() == 0 ||
                        (sb.length() == 1 && (sb.charAt(0) == '-' || sb.charAt(0) == '+'))) continue;
                sb.append(str.charAt(i));
            }else if(('9'>=str.charAt(i)&&str.charAt(i)>'0')){
                isStart = true;
                sb.append(str.charAt(i));
            }else if(str.charAt(i) == '-'||str.charAt(i)=='+'){
                if(isStart) break;
                sb.append(str.charAt(i));
                isStart = true;
            }else if(str.charAt(i) == ' ' && !isStart){
            }else{
                break;
            }
        }
        String result = sb.toString();
        if(result.length() == 0
                || (result.length() == 1 && (result.charAt(0)=='-'||result.charAt(0)=='+')))
            return 0;
        if(result.charAt(0) == '-' &&
                ((result.length() == 11 && result.compareTo(Integer.MIN_VALUE+"")>=0)
                        || result.length() > 11))
            return Integer.MIN_VALUE;
        if(result.charAt(0) == '+')
            result = result.substring(1);
        if(result.charAt(0) != '-'){
            if((result.length() == 10 && result.compareTo(Integer.MAX_VALUE+"")>0) || result.length() > 10 )
                return Integer.MAX_VALUE;
        }
        return Integer.parseInt(result);
    }
}
