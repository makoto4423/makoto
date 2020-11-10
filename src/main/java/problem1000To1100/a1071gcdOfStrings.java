package problem1000To1100;

public class a1071gcdOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        String res = "";
        int len = Math.min(str1.length(), str2.length());
        for (int i = 0; i < len; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            }
            sb.append(str1.charAt(i));
            if (str1.length() % sb.length() == 0 && str2.length() % sb.length() == 0) {
                int dup = str1.length() / sb.length();
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < dup; j++) {
                    temp.append(sb);
                }
                if (temp.toString().equals(str1)) {
                    dup = str2.length() / sb.length();
                    temp = new StringBuilder();
                    for (int j = 0; j < dup; j++) {
                        temp.append(sb);
                    }
                    if (temp.toString().equals(str2)) {
                        res = sb.toString();
                    }
                }
            }
        }
        return res;
    }

}
