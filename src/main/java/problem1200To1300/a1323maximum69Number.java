package problem1200To1300;

public class a1323maximum69Number {
    public int maximum69Number (int num) {
        String s = num+"";
        boolean update = false;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '6' && !update){
                sb.append(9);
                update = true;
            }else{
                sb.append(s.charAt(i));
            }
        }
        return Integer.parseInt(sb.toString());
    }
}
