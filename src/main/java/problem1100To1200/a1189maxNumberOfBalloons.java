package problem1100To1200;

public class a1189maxNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        int[] arr = new int[26];
        for (char ch : text.toCharArray()) {
            arr[ch - 'a']++;
        }
        int b = arr[1];
        int a = arr[0];
        int l = arr[11] / 2;
        int o = arr[14] / 2;
        int n = arr[13];
        return Math.min(b, Math.min(a, Math.min(l, Math.min(o, n))));
    }
}
