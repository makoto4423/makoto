package problem1500To1600;

/**
 * 看了答案感觉自己宛若智障
 */
@Deprecated
public class a1540canConvertString {
    public boolean canConvertString(String s, String t, int k) {
        if(s.length() != t.length())    return false;
        int[] arr = new int[26];
        for(int i=0;i<s.length();i++){
            int num = t.charAt(i)-s.charAt(i);
            if(num < 0){
                num += 26;
            }
            arr[num]++;
        }
        for(int i=1;i<26;i++){
            int move = i+26*(arr[i]-1);
            if(move > k){
                return false;
            }
        }
        return true;
//        Set<Integer> set = new HashSet<>();
//        if(s.length() != t.length())    return false;
//        for(int i=0;i<s.length();i++){
//            int num = t.charAt(i)-s.charAt(i);
//            if(num == 0)    continue;
//            if(num < 0){
//                num = 'z'-s.charAt(i)+t.charAt(i)-'a'+1;
//            }
//            while (set.contains(num)){
//                num += 26;
//            }
//            if(num > k){
//                return false;
//            }
//            set.add(num);
//        }
//        return true;
    }
}
