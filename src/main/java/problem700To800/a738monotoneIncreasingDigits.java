package problem700To800;

public class a738monotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        String s = N + "";
        int  i = 0;
        for (; i < s.length() - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) break;
        }
        if (i == s.length()-1) return N;
        while (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
            i--;
        }
        StringBuilder sb = new StringBuilder(s.substring(0, i));
        sb.append(Integer.parseInt(s.charAt(i++) + "") - 1);
        for (; i < s.length(); i++) {
            sb.append(9);
        }
        return Integer.parseInt(sb.toString());
    }
}
