package problem400To500;

public class a415addStrings {
    public String addStrings(String num1, String num2) {
        int index1 = num1.length()-1,index2=num2.length()-1, tag = 0;
        StringBuilder sb = new StringBuilder();
        while (index1 >= 0 && index2>=0){
            int i1 = Integer.parseInt(num1.charAt(index1--)+"");
            int i2 = Integer.parseInt(num2.charAt(index2--)+"");
            int a = i1+i2+tag;
            if(a >= 10){
                a -= 10;
                tag = 1;
            }else{
                tag = 0;
            }
            sb.append(a);
        }
        while (index1 >= 0){
            int i1 = Integer.parseInt(num1.charAt(index1--)+"");
            int a = i1+tag;
            if(a >= 10){
                a -= 10;
                tag = 1;
            }else {
                tag = 0;
            }
            sb.append(a);
        }
        while (index2 >= 0){
            int i2 = Integer.parseInt(num2.charAt(index2--)+"");
            int a = i2+tag;
            if(a >= 10){
                a -= 10;
                tag = 1;
            }else {
                tag = 0;
            }
            sb.append(a);
        }
        if(tag == 1){
            sb.append(tag);
        }
        return sb.reverse().toString();
    }
}
