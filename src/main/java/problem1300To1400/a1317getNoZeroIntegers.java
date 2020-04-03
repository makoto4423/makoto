package problem1300To1400;

public class a1317getNoZeroIntegers {
    public int[] getNoZeroIntegers(int n) {
        String s = n+"";
        StringBuilder sb = new StringBuilder();
        boolean tag = true;
        for (int i=s.length()-1; i>= 0; i--){
            int k = s.charAt(i)-'0';
            if(!tag && k == 0 && i != 0){
                 sb.append(4);continue;
            }
            if(!tag) k--;
            if(k == 0 || k==1){
                if(i==0){
                    if(k != 0){
                        sb.append(k);
                    }
                    continue;
                }
                tag=false;
                sb.append((10+k)/2);
            }else{
                tag = true;
                sb.append(k/2);
            }
        }
        sb = sb.reverse();
        int a = Integer.parseInt(sb.toString());
        int b = n-a;
        return new int[]{a,b};

    }
}
