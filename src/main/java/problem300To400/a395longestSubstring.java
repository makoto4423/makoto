package problem300To400;

// 瞄了眼答案，分治，然后就写出来了
@Deprecated
public class a395longestSubstring {
    public int longestSubstring(String s, int k) {
        int[] stat = new int[26];
        for(char ch : s.toCharArray()){
            stat[ch-'a']++;
        }
        int i=0;
        for(;i<26;i++){
            if(stat[i]<k && stat[i] != 0){
                break;
            }
        }
        char ch = (char) ('a'+i);
        int j = 0;
        for(;j<s.length();j++){
            if(s.charAt(j) == ch){
                break;
            }
        }
        if(j == s.length()){
            return s.length();
        }
        return Math.max(j == 0 ? 0 : longestSubstring(s.substring(0,j),k),longestSubstring(s.substring(j+1),k));
    }
}
