package problem1To100;

public class a67addBinary {
    public String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        if(aLen > bLen){
            StringBuilder bBuilder = new StringBuilder(b);
            for(int i = 0; i<aLen-bLen; i++){
                bBuilder.insert(0, "0");
            }
            b = bBuilder.toString();
        }else if(bLen > aLen){
            StringBuilder aBuilder = new StringBuilder(a);
            for(int i = 0; i<bLen-aLen; i++){
                aBuilder.insert(0, "0");
            }
            a = aBuilder.toString();
        }
        int add = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=a.length()-1;i>=0;i--){
            int m = Integer.parseInt(a.charAt(i)+"");
            int n = Integer.parseInt(b.charAt(i)+"");
            if(m+n+add>=2){
                sb.append(m+n+add-2);
                add = 1;
            }else{
                sb.append(m+n+add);
                add = 0;
            }
        }
        if(add == 1){
            sb.append("1");
        }
        return sb.reverse().toString();
    }
}
