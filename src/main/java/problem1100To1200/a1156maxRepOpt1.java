package problem1100To1200;
// 写多了，开始出现写过的错觉
// 看到提交记录，18天前还真的是写过，不过没写出来
public class a1156maxRepOpt1 {
    public int maxRepOpt1(String text) {
        return Math.max(cal(text), cal(new StringBuilder(text).reverse().toString()));
    }

    public int cal(String text){
        int res = 1, temp = 1;
        for(int i=1;i<text.length();i++){
            if(text.charAt(i) == text.charAt(i-1)){
                temp++;
            }else{
                int aft=text.length()-1;
                for(;aft>i;aft--){
                    if(text.charAt(aft)==text.charAt(i-1))  break;
                }
                if(aft == i){
                    res = Math.max(res,temp);
                    temp = 1;
                    continue;
                }
                temp++;
                for(int j=i+1;j<aft;j++){
                    if(text.charAt(j) == text.charAt(i-1)){
                        temp++;
                    }else{

                        break;
                    }
                }
                res = Math.max(temp,res);
                temp = 1;
            }
        }
        return Math.max(temp,res);
    }
}
