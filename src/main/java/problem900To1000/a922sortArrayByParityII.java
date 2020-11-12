package problem900To1000;

public class a922sortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        int len = A.length;
        int[] a1 = new int[len / 2];
        int[] a2 = new int[len / 2];
        int m = 0, n = 0;
        for (int i : A) {
            if (i % 2 == 0) a1[m++] = i;
            else a2[n++] = i;
        }
        m = 0;
        n = 0;
        for (int i = 0; i < len; i = i + 2) {
            A[i] = a1[m++];
            A[i + 1] = a2[n++];
        }
        return A;
    }
}
