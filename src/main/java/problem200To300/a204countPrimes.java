package problem200To300;

import java.util.ArrayList;
import java.util.List;

@Deprecated
public class a204countPrimes {
    public int countPrimes(int n) {
        int[] arr = new int[n];
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (arr[i] == 0) {
                res++;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        arr[j] = 1;
                    }
                }
            }
        }
        return res;
    }
}
