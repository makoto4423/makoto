package problem1000To1100;

public class a1006clumsy {
    public int clumsy(int N) {
        int start = 0;
        int res = N;
        N--;
        while (N != 0) {
            if (start == 0) {
                res *= N;
            } else if (start == 1) {
                res /= N;
            } else if (start == 2) {
                res += N;
            } else if (start == 3) {
                if (N == 1) {
                    res -= N;
                } else if (N == 2) {
                    res -= 2;
                } else {
                    int temp = N * (N - 1) / (N - 2);
                    res -= temp;
                    N -= 2;
                    start += 2;
                }
            }
            start++;
            start %= 4;
            N--;
        }
        return res;
    }
}
