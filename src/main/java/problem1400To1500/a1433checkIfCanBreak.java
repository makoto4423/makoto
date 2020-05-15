package problem1400To1500;

import java.util.Arrays;

public class a1433checkIfCanBreak {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        int len = ch1.length;
        if(len == 0)    return true;
        int[] stat = new int[len];
        for(int i=0;i<len;i++){
            stat[i] = ch1[i]-ch2[i];
        }
        Arrays.sort(stat);
        return stat[0]*stat[len-1]>=0;
    }
}
