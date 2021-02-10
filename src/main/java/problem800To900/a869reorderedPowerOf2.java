package problem800To900;

public class a869reorderedPowerOf2 {
    public boolean reorderedPowerOf2(int N) {
        if (N == 1) return true;
        int[] arr = new int[10];
        int a = N;
        while (a != 0) {
            arr[a % 10]++;
            a /= 10;
        }
        int limit = 0;
        for (int i = 9; i >= 0; i--) {
            int t = arr[i];
            while (t != 0) {
                limit = limit * 10 + i;
                t--;
            }
        }
        int s = 1;
        while (s <= limit) {
            int t = s;
            int[] now = new int[10];
            while (t != 0) {
                now[t % 10]++;
                t /= 10;
            }
            int i = 0;
            for (; i < 10; i++) {
                if (arr[i] != now[i]) break;
            }
            if (i == 10) return true;
            s = s << 1;
        }
        return false;
    }
}
