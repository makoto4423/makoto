package match.a0822;

public class a5749thousandSeparator {
    public String thousandSeparator(int n) {
        if (n == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int a = n % 1000;
            sb.insert(0, a);
            n /= 1000;
            if (n != 0) {
                if (a < 100) {
                    if (a < 10) {
                        sb.insert(0, "00");
                    } else {
                        sb.insert(0, 0);
                    }
                }
                sb.insert(0, '.');
            }
        }
        return sb.toString();
    }
}
