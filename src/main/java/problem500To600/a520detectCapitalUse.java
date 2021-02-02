package problem500To600;

public class a520detectCapitalUse {
    public boolean detectCapitalUse(String word) {
        int len = word.length();
        if (len == 0) return false;
        if (len == 1) return true;
        boolean head = word.charAt(0) >= 'A' && word.charAt(0) <= 'Z';
        if (head) {
            boolean next = word.charAt(1) >= 'A' && word.charAt(1) <= 'Z';
            if (next) {
                for (char c : word.toCharArray()) {
                    if (c >= 'a' && c <= 'z') return false;
                }
            } else {
                for (int i = 2; i < len; i++) {
                    if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') return false;
                }
            }
        } else {
            for (char c : word.toCharArray()) {
                if (c >= 'A' && c <= 'Z') return false;
            }
        }
        return true;
    }
}
