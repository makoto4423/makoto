package problem900To1000;

public class a925isLongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        if (name.length() == 0) return false;
        int i = 0, j = 0;
        while (i < name.length() && j < typed.length()) {
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j != 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        if (i != name.length()) {
            return false;
        }
        if (j != typed.length()) {
            for (; j < typed.length(); j++) {
                if (typed.charAt(j) != typed.charAt(j - 1)) {
                    return false;
                }
            }
        }
        return true;
    }
}
