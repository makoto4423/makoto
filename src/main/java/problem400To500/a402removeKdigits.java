package problem400To500;

// 暴力超时，还是要总结出数学规律
@Deprecated
public class a402removeKdigits {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (k == 0) return num.length() == 0 ? "0" : num;
        if (num.length() < 2) return "0";
        int i = 0;
        for (; i < num.length() - 1; i++) {
            if (num.charAt(i) > num.charAt(i + 1)) {
                break;
            }
        }
        if (i == len - 1) {
            num = num.substring(0, i);
        } else if (i != 0) {
            num = num.substring(0, i) + num.substring(i + 1);
        } else {
            num = num.substring(i + 1);
        }
        if (num.charAt(0) == '0') {
            i = 0;
            for (; i < num.length(); i++) {
                if (num.charAt(i) != '0') break;
            }
            num = num.substring(i);
        }
        return removeKdigits(num, k - 1);
//        if (k == 0) return num.length() == 0 ? "0" : num;
//        if (num.length() < 2) return "0";
//        String val = num.substring(1);
//        for (int i = 1; i <= num.length(); i++) {
//            String temp = num.substring(0, i - 1) + num.substring(i);
//            val = val.compareTo(temp) >= 0 ? temp : val;
//        }
//        if (val.charAt(0) == '0') {
//            int i = 0;
//            for (; i < val.length(); i++) {
//                if (val.charAt(i) != '0') break;
//            }
//            val = val.substring(i);
//        }
//        return removeKdigits(val + "", k - 1);
    }
}
