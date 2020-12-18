package problem1200To1300;

public class a1287findSpecialInteger {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length / 4;
        for (int i = 0; i < arr.length - n; i++) {
            if (arr[i] == arr[i + n]) {
                return arr[i];
            }
        }
        return -1;
    }
}
