package problem600To700;

public class a657judgeCircle {
    public boolean judgeCircle(String moves) {
        int up = 0, right = 0;
        for (char ch : moves.toCharArray()) {
            if (ch == 'U') {
                up++;
            } else if (ch == 'D') {
                up--;
            } else if (ch == 'R') {
                right++;
            } else {
                right--;
            }
        }
        return up == 0 && right == 0;
    }
}
