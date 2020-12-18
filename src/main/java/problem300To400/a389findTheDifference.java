package problem300To400;

public class a389findTheDifference {
    public char findTheDifference(String s, String t) {
        int[] a1 = new int[26];
        int[] a2 = new int[26];
        for (char c : s.toCharArray()) {
            a1[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            a2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (a1[i] != a2[i]) {
                return ((char) (i + 'a'));
            }
        }
        return 'a';
    }
}
