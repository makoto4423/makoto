package problem700To800;

public class a771numJewelsInStones {
    public int numJewelsInStones(String J, String S) {
        boolean[] b = new boolean[58];
        for (char ch : J.toCharArray()) {
            b[ch - 'A'] = true;
        }
        int res = 0;
        for (char ch : S.toCharArray()) {
            if (b[ch - 'A']) {
                res++;
            }
        }
        return res;
    }
}
