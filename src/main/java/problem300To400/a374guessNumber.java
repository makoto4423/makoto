package problem300To400;

public class a374guessNumber extends GuessGame {

    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == -1) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}

class GuessGame {
    int guess(int num) {
        return -1;
    }
}
