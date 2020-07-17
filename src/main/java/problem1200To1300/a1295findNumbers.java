package problem1200To1300;

public class a1295findNumbers {
    public int findNumbers(int[] nums) {
        int res = 0;
        for (int i : nums) {
            String s = i + "";
            if (s.length() % 2 == 0) res++;
        }
        return res;
    }
}
