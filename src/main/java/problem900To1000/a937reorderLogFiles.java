package problem900To1000;

import java.util.ArrayList;
import java.util.List;

public class a937reorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        List<String> number = new ArrayList<>();
        List<String> ch = new ArrayList<>();
        for (String s : logs) {
            String content = s.substring(s.indexOf(' ')).replaceAll(" ", "");
            if (isNumber(content)) {
                number.add(s);
            } else {
                ch.add(s);
            }
        }
        ch.sort((o1, o2) -> {
            String content1 = o1.substring(o1.indexOf(' '));
            String content2 = o2.substring(o2.indexOf(' '));
            if (content1.compareTo(content2) != 0) {
                return content1.compareTo(content2);
            }
            String head1 = o1.substring(0, o1.indexOf(' '));
            String head2 = o2.substring(0, o2.indexOf(' '));
            return head1.compareTo(head2);
        });
        String[] res = new String[logs.length];
        int i = 0;
        for (String s : ch) {
            res[i++] = s;
        }
        for (String s : number) {
            res[i++] = s;
        }
        return res;
    }

    public boolean isNumber(String s) {
        for (char ch : s.toCharArray()) {
            if (ch > '9' || ch < '0') return false;
        }
        return true;
    }
}
