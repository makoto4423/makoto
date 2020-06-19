package problem1200To1300;

public class a1209removeDuplicates {
    public String removeDuplicates(String s, int k) {
        String pre = s;
        StringBuilder aft = new StringBuilder(s);
        do {
            pre = aft.toString();
            aft = new StringBuilder();
            for (int i = 0; i < pre.length(); i++) {
                if (i + k > pre.length()) {
                    aft.append(pre, i, pre.length());
                    break;
                } else {
                    if (i < pre.length() - 1 && pre.charAt(i) == pre.charAt(i + 1)) {
                        int j = i;
                        while (j < i + k && j < pre.length() - 1 && pre.charAt(j) == pre.charAt(j + 1)) {
                            j++;
                        }
                        if (j == i + k - 1) {
                            i = i + k - 1;
                        } else {
                            aft.append(pre.charAt(i));
                        }
                    } else {
                        aft.append(pre.charAt(i));
                    }
                }
            }
        } while (pre.length() != aft.length());
        return aft.toString();
    }
}
