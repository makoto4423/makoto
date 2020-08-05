package problem800To900;

public class a848shiftingLetters {
    public String shiftingLetters(String S, int[] shifts) {
        shifts[shifts.length-1] %= 26;
        for(int i=shifts.length-2;i>=0;i--){
            shifts[i] = (shifts[i+1]+shifts[i])%26;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<shifts.length;i++){
            sb.append((char) ((S.charAt(i)-'a'+shifts[i])%26+'a'));
        }
        return sb.toString();
    }
}
