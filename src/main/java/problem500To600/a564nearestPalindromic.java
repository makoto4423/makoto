package problem500To600;

// 企图分情况分析，分着分着就卡住了，卡在当数字不是回文时，取自身的回文，还是+1或-1,无比靠近答案却无法得出正确答案，疯了
// 两个小时了，卡在int类型溢出的问题上
// 神啊，我终于搞定了，写了两个小时(13:56-15.46)终于把hard给ko了，干
public class a564nearestPalindromic {
    public String nearestPalindromic(String n) {
        String res = "";
        if(chePal(n)){
            res =  isPal(n);
        }else{
            res =  notPal(n);
        }
        int len = n.length();
        long ans = Long.parseLong(res);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<len-1;i++){
            sb.append("9");
        }
        if(sb.toString().equals("")) return res;
        long small = Long.parseLong(sb.toString());
        if(Math.abs(ans-Long.parseLong(n)) >= Math.abs(small-Long.parseLong(n))){
            ans = small;
        }
        return String.valueOf(ans);
    }

    public boolean chePal(String n){
        for(int i=0;i<n.length()/2;i++){
            if(n.charAt(i) != n.charAt(n.length()-i-1)) return false;
        }
        return true;
    }

    public String isPal(String n){
        int len = n.length();
        StringBuilder stringBuilder = new StringBuilder();
        for(int k=0;k<len;k++){
            stringBuilder.append('9');
        }
        long i = Long.parseLong(n);
        if(i != 9 && n.equals(stringBuilder.toString())){
            return String.valueOf(i+2);
        }
        if(len % 2 == 1){
            if(n.charAt(len/2) > '0'){
                return n.substring(0,len/2)+toChar(n.charAt(len/2)-1)+n.substring(len/2+1);
            }else{
                return n.substring(0,len/2)+"1"+n.substring(len/2+1);
            }
        }else{
            if(n.equals("11"))   return "22";
            if(n.charAt(len/2) > '0'){
                return n.substring(0,len/2-1)+toChar(n.charAt(len/2)-1)+toChar(n.charAt(len/2)-1)+n.substring(len/2+1);
            }else{
                return n.substring(0,len/2-1)+"00"+n.substring(len/2+1);
            }
        }
    }

    public String notPal(String n){
        StringBuilder sb = new StringBuilder();
        int len = n.length();
        for(int i=0;i<=n.length()/2;i++){
            sb.append(n.charAt(i));
        }
        StringBuilder res;
        if(len%2 ==1 ){
            res = new StringBuilder(sb);
        }else{
            res = new StringBuilder(sb.substring(0,sb.length()-1));
        }
        int m = sb.length()-2;
        for(;m>=0;m--){
            res.append(sb.charAt(m));
        }
        if(len%2 == 0){
            long small = Long.MAX_VALUE;
            long big = Long.MAX_VALUE;
            if(res.charAt(len/2) != '0'){
                small = Long.parseLong(res.substring(0,len/2-1)+toChar(res.charAt(len/2)-1)+toChar(res.charAt(len/2)-1)+res.substring(len/2+1));
            }
            if(res.charAt(len/2) != '9'){
                big = Long.parseLong(res.substring(0,len/2-1)+toChar(res.charAt(len/2)+1)+toChar(res.charAt(len/2)+1)+res.substring(len/2+1));
            }
            long ans = Long.parseLong(res.toString());
            long i = Long.parseLong(n);
            if(Math.abs(ans-i)>=Math.abs(i-small)){
                ans = small;
            }
            if(Math.abs(ans-i) > Math.abs(big-i)){
                ans = big;
            }
            res = new StringBuilder(String.valueOf(ans));
        }else{
            long small = Long.MAX_VALUE;
            long big = Long.MAX_VALUE;
            if(res.charAt(len/2) != '0'){
                small = Long.parseLong(res.substring(0,len/2)+toChar(res.charAt(len/2)-1)+res.substring(len/2+1));
            }
            if(res.charAt(len/2) != '9'){
                big = Long.parseLong(res.substring(0,len/2)+toChar(res.charAt(len/2)+1)+res.substring(len/2+1));
            }
            long ans = Long.parseLong(res.toString());
            long i = Long.parseLong(n);
            if(Math.abs(ans-i)>=Math.abs(i-small)){
                ans = small;
            }
            if(Math.abs(ans-i) > Math.abs(big-i)){
                ans = big;
            }
            res = new StringBuilder(String.valueOf(ans));
        }
        return res.toString();
    }

    public char toChar(int i){
        return (char)(i);
    }
}
