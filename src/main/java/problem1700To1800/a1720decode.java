package problem1700To1800;

public class a1720decode {
    public int[] decode(int[] encoded, int first) {
        int n = encoded.length;
        int[] de = new int[n + 1];
        de[0] = first;
        for (int i = 1; i <= n; i++) {
            de[i] = de[i - 1] ^ encoded[i - 1];
        }
        return de;
    }
}
