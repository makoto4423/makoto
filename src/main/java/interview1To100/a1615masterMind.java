package interview1To100;

import java.util.HashSet;
import java.util.Set;
// 参考答案写的
public class a1615masterMind {
    public int[] masterMind(String solution, String guess) {
        int[] ans = new int[2];
        int len = solution.length();
        char[] ch1 = solution.toCharArray();
        char[] ch2 = guess.toCharArray();

        for( int i=0; i<len; i++ ){
            if( ch1[i] == ch2[i] ){
                ans[0]++;
                ch1[i] = ch2[i] = '0';
            }

        }
        for( int i=0; i<len; i++ ){
            for( int j=0; j<len; j++ ){
                if( ch1[i] == ch2[j] && i!=j && ch1[i] != '0' ){
                    ans[1]++;
                    ch1[i] = '8';
                    ch2[j] = '7';
                }
            }
        }

        return ans;
    }
}
