package match.a0307;

public class CheckOnesSegment {
    public boolean checkOnesSegment(String s) {
        int n = s.length();
        if (n == 1) return true;
        int i = 1;
        for (; i < n; i++) {
            if (s.charAt(i) == '0') break;
        }
        for (; i < n; i++) {
            if (s.charAt(i) == '1') return false;
        }
        return true;
    }
}
