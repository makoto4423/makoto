package interview1To100;
// 答案通过统计a,b出现的次数来缩减循环的次数，不算难，但是繁杂
@Deprecated
public class a1618patternMatching {
    public boolean patternMatching(String pattern, String value) {
        int count_a = 0, count_b = 0;
        for (char ch: pattern.toCharArray()) {
            if (ch == 'a') {
                ++count_a;
            } else {
                ++count_b;
            }
        }
        if (count_a < count_b) {
            int temp = count_a;
            count_a = count_b;
            count_b = temp;
            char[] array = pattern.toCharArray();
            for (int i = 0; i < array.length; i++) {
                array[i] = array[i] == 'a' ? 'b' : 'a';
            }
            pattern = new String(array);
        }
        if (value.length() == 0) {
            return count_b == 0;
        }
        if (pattern.length() == 0) {
            return false;
        }
        for (int len_a = 0; count_a * len_a <= value.length(); ++len_a) {
            int rest = value.length() - count_a * len_a;
            if ((count_b == 0 && rest == 0) || (count_b != 0 && rest % count_b == 0)) {
                int len_b = (count_b == 0 ? 0 : rest / count_b);
                int pos = 0;
                boolean correct = true;
                String value_a = "", value_b = "";
                for (char ch: pattern.toCharArray()) {
                    if (ch == 'a') {
                        String sub = value.substring(pos, pos + len_a);
                        if (value_a.length() == 0) {
                            value_a = sub;
                        } else if (!value_a.equals(sub)) {
                            correct = false;
                            break;
                        }
                        pos += len_a;
                    } else {
                        String sub = value.substring(pos, pos + len_b);
                        if (value_b.length() == 0) {
                            value_b = sub;
                        } else if (!value_b.equals(sub)) {
                            correct = false;
                            break;
                        }
                        pos += len_b;
                    }
                }
                if (correct && !value_a.equals(value_b)) {
                    return true;
                }
            }
        }
        return false;
//        if(pattern.length() == 0 && value.length() == 0)    return true;
//        if(pattern.length() == 0)    return false;
//        if(value.length() == 0) return pattern.indexOf('a') == -1 || pattern.indexOf('b') == -1;
//        String a = "";
//        String b = "";
//        int aLen = 0, bLen = 0;
//        while (aLen != value.length()+1 || bLen != value.length()+1) {
//            int pos = 0;
//            StringBuilder sb = new StringBuilder();
//            int i = 0;
//            for (; i < pattern.length(); i++) {
//                char ch = pattern.charAt(i);
//                if (ch == 'a') {
//                    if (a.length() == 0) {
//                        if (pos + aLen > value.length()) {
//                            break;
//                        }
//                        a = value.substring(pos, pos+aLen);
//
//                    }
//                    sb.append(a);
//                    pos += aLen;
//                }
//                if (ch == 'b') {
//                    if (b.length() == 0) {
//                        if (pos + bLen > value.length()) {
//                            break;
//                        }
//                        b = value.substring(pos, pos+bLen);
//                    }
//                    sb.append(b);
//                    pos += bLen;
//                }
//                if (value.indexOf(sb.toString()) != 0) {
//                    break;
//                }
//            }
//            if (sb.toString().equals(value) && i==pattern.length() && ((a.length() == 0&&b.length()==0) || !a.equals(b))) {
//                return true;
//            }
//            if (aLen != value.length()+1) {
//                aLen++;
//            } else if (bLen != value.length()+1) {
//                aLen = 0;
//                bLen++;
//            }
//            a = "";
//            b = "";
//        }
//        return false;
    }
}
