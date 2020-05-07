package problem500To600;

import java.util.*;
// 滑动窗口，移动s2的坐标
@Deprecated
public class a567checkInclusion {
    public boolean checkInclusion(String s1, String s2) {
        int aLen = s1.length();
        int bLen = s2.length();
        int[] pos = new int[26];
        for(int i=0;i<aLen;i++){
            pos[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<bLen-aLen+1;i++){
            int[] cp = new int[26];
            System.arraycopy(pos, 0, cp, 0, 26);
            int j=i;
            for(;j<i+aLen;j++){
                cp[s2.charAt(j)-'a']--;
                if(cp[s2.charAt(j)-'a']==-1)
                    break;
            }
            if(j==i+aLen) return true;
        }
        return false;
    }
}
