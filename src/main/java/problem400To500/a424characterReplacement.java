package problem400To500;

@Deprecated
public class a424characterReplacement {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0, max = 0, n = s.length();
        int[] arr = new int[26];
        while (r < n) {
            arr[s.charAt(r) - 'A']++;
            max = Math.max(max, arr[s.charAt(r) - 'A']);
            if (r - l + 1 - max > k) {
                arr[s.charAt(l) - 'A']--;
                l++;
            }
            r++;
        }
        return r - l;
    }
}
