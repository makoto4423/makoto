package problem1000To1100;

public class a1047removeDuplicates {
    public String removeDuplicates(String S) {
        int len = S.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != S.charAt(i)) {
                sb.append(S.charAt(i));
            } else {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }
}
