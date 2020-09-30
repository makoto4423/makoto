package problem800To900;

public class a859buddyStrings {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.length() < 2) return false;
        if (A.equals(B)) {
            int[] stat = new int[26];
            for (char ch : A.toCharArray()) {
                stat[ch - 'a']++;
            }
            for (int i : stat) {
                if (i > 1) return true;
            }
            return false;
        }
        int d1 = -1, d2 = -1;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                if (d1 == -1) {
                    d1 = i;
                } else if (d2 == -1) {
                    d2 = i;
                } else {
                    return false;
                }
            }
        }
        if (d1 == -1 || d2 == -1) {
            return false;
        }
        return A.charAt(d1) == B.charAt(d2) && A.charAt(d2) == B.charAt(d1);
    }
}
