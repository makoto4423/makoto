package problem600To700;

public class a696countBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int res=0,tag =0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '0' && tag >= 0){
                tag++;
            }else if(ch == '1' && tag<=0){
                tag--;
            }else{
                for(int j=i;j<s.length();j++){
                    if(tag != 0){
                        if(s.charAt(j) == '1' && tag > 0){
                            tag--;
                            res++;
                        }else if(s.charAt(j) == '0' && tag <0){
                            tag++;
                            res++;
                        }else{
                            break;
                        }
                    }else {
                        break;
                    }
                }
                tag = s.charAt(i) == '0' ? 1 : -1;
            }
        }
        return res;
    }
}
