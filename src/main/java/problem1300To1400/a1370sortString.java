package problem1300To1400;

public class a1370sortString {
    public String sortString(String s) {
        int len = s.length();
        int[] arr = new int[26];
        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (sb.length() != len) {
            if (i == 0) {
                for (; i < 26; i++) {
                    if (arr[i] != 0) {
                        arr[i]--;
                        sb.append((char) (i + 'a'));
                    }
                }
                i--;
            } else {
                for (; i >= 0; i--) {
                    if (arr[i] != 0) {
                        if (arr[i] != 0) {
                            arr[i]--;
                            sb.append((char) (i + 'a'));
                        }
                    }
                }
                i++;
            }
        }
        return sb.toString();
    }
}
