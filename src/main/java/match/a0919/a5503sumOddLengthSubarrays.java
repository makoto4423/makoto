package match.a0919;

public class a5503sumOddLengthSubarrays {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int temp = sum;
            for (int j = arr.length - 1; j >= i; j--) {
                if ((j - i) % 2 == 0) {
                    res += temp;
                }
                temp -= arr[j];
            }
            sum -= arr[i];
        }
        return res;
    }
}
