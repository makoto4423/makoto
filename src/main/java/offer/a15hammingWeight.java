package offer;

public class a15hammingWeight {
    public int hammingWeight(int n) {
        int res = 0;
        String s = Integer.toBinaryString(n);
        for (char ch : s.toCharArray()) {
            if (ch == '1') res++;
        }
        return res;
    }
}
