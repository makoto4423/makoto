package problem300To400;

public class a387firstUniqChar {
    public int firstUniqChar(String s) {
        int[] stat = new int[26];
        int res = Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(stat[ch-'a'] == 0){
                stat[ch-'a'] = i+1;
            }else{
                stat[ch-'a'] = -1;
            }
        }
        for(int i : stat){
            if(i>0){
                res = Math.min(i,res);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res-1;
    }
}
