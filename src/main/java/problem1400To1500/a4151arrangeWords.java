package problem1400To1500;
// 没想到arrays.sort，自己用冒泡写了一遍
public class a4151arrangeWords {
    public String arrangeWords(String text) {
        String[] ss = text.split(" ");
        for(int i=0;i<ss.length;i++){
            for(int j=i+1;j<ss.length;j++){
                if(ss[i].length() > ss[j].length()){
                    String temp = ss[j];
                    if (j - i >= 0) System.arraycopy(ss, i, ss, i + 1, j - i);
                    ss[i] = temp;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String s : ss){
            sb.append(s).append(" ");
        }
        String s = sb.toString();
        s=s.toLowerCase();
        s = s.substring(0,1).toUpperCase()+s.substring(1,s.length()-1);
        return s;
    }
}
