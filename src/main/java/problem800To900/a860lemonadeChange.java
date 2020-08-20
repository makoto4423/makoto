package problem800To900;

public class a860lemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int amount5 = 0, amount10 = 0;
        for (int i : bills) {
            if (i == 5) {
                amount5++;
            } else if (i == 10) {
                if (amount5 < 1) return false;
                amount5--;
                amount10++;
            } else {
                if (amount5 > 0 && amount10 > 0) {
                    amount5--;
                    amount10--;
                } else if (amount5 > 2) {
                    amount5 -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
