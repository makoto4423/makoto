package problem1200To1300;

public class a1232checkStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length < 3) return true;
        double d = coordinates[1][0] == coordinates[0][0] ? Double.MAX_VALUE : (double) (coordinates[1][1] - coordinates[0][1]) / (coordinates[1][0] - coordinates[0][0]);
        for (int i = 2; i < coordinates.length; i++) {
            double p = coordinates[i][0] == coordinates[0][0] ? Double.MAX_VALUE :(double) (coordinates[i][1] - coordinates[0][1]) / (coordinates[i][0] - coordinates[0][0]);
            if (p != d) return false;
        }
        return true;
    }
}
