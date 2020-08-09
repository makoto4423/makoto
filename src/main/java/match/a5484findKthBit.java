package match;

public class a5484findKthBit {
    public char findKthBit(int n, int k) {
        String s = "0";
        while (n-1 != 0){
            StringBuilder temp = new StringBuilder(s+"1");
            StringBuilder invert = new StringBuilder();
            for(char ch : s.toCharArray()){
                if(ch == '0'){
                    invert.append(1);
                }else{
                    invert.append(0);
                }
            }
            temp.append(invert.reverse());
            if(temp.length() >= k){
                return temp.charAt(k-1);
            }
            s = temp.toString();
            n--;
        }
        return s.charAt(k-1);
    }
}
