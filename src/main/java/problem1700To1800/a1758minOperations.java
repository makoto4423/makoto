package problem1700To1800;

public class a1758minOperations {
    public int minOperations(String s) {
        int n = s.length();
        StringBuilder s0 = new StringBuilder();
        StringBuilder s1 = new StringBuilder();
        for (int i = 0; i < n; i++) {
            s0.append(i % 2);
            s1.append((i + 1) % 2);
        }
        int re0 = 0, re1 = 0;
        for (int i = 0; i < n; i++) {
            if (s0.charAt(i) != s.charAt(i)) {
                re0++;
            }
            if (s1.charAt(i) != s.charAt(i)) {
                re1++;
            }
        }
        return Math.min(re0, re1);
    }
}
