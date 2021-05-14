package problem1To100;

public class a12intToRoman {
    public String intToRoman(int num) {
        char[] one = {'I', 'X', 'C', 'M'};
        char[] five = {'V', 'L', 'D'};
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int v = num % 10;
            if (v != 0) {
                if (v <= 5) {
                    if (v == 5) {
                        sb.insert(0, five[i]);
                    } else if (v == 4) {
                        sb.insert(0, "" + one[i] + five[i]);
                    } else {
                        while (v != 0) {
                            sb.insert(0, one[i]);
                            v--;
                        }
                    }
                } else {
                    if (v == 9) {
                        sb.insert(0, "" + one[i] + one[i + 1]);
                    } else {
                        StringBuilder s = new StringBuilder(five[i] + "");
                        v -= 5;
                        while (v != 0) {
                            s.append(one[i]);
                            v--;
                        }
                        sb.insert(0, s);
                    }
                }
            }
            i++;
            num /= 10;
        }
        return sb.toString();
    }
}
