package problem1400To1500;

public class a1442countTriplets {

    public int countTriplets(int[] arr) {
        int res = 0;
        int n = arr.length;
        int sum = 0;
        int[] br = new int[n];
        for (int i = 0; i < n; i++) {
            sum ^= arr[i];
            br[i] = sum;
        }
        int left = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int now = br[j] ^ left;
                int select = 0;
                for (int k = i; k < j; k++) {
                    select ^= arr[i];
                    if (select == (now ^ select)) {
                        res++;
                    }
                }
            }
            left ^= arr[i];
        }
        return res;
    }

}
