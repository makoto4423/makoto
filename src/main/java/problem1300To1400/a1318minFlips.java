package problem1300To1400;

public class a1318minFlips {
    StringBuilder as,bs,cs;
    public int minFlips(int a, int b, int c) {
        as = new StringBuilder(Integer.toBinaryString(a));
        bs = new StringBuilder(Integer.toBinaryString(b));
        cs = new StringBuilder(Integer.toBinaryString(c));
        fill();
        int res = 0;
        for(int i=0;i<as.length();i++){
            if(cs.charAt(i) == '1'){
                if(as.charAt(i) != '1' && bs.charAt(i) != '1'){
                    res++;
                }
            }else{
                if(as.charAt(i) == '1') res++;
                if(bs.charAt(i) == '1') res++;
            }
        }
        return res;
    }

    public void fill(){
        int len = Math.max(as.length(),Math.max(bs.length(),cs.length()));
        while (as.length() != len){
            as.insert(0,"0");
        }
        while (bs.length() != len){
            bs.insert(0,"0");
        }
        while (cs.length() != len){
            cs.insert(0,"0");
        }
    }

}
