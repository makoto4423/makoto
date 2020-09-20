package match.a0920;

import java.util.ArrayList;
import java.util.List;

public class a5519reorderSpaces {
    public String reorderSpaces(String text) {
        List<String> list = new ArrayList<>();
        int empty = 0;
        StringBuilder sb = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (ch == ' ') {
                if (sb.length() != 0) {
                    list.add(sb.toString());
                    sb = new StringBuilder();
                }
                empty++;
            } else {
                sb.append(ch);
            }
        }
        if(sb.length() != 0){
            list.add(sb.toString());
        }
        int size = list.size() == 1 ? 0 : empty / (list.size() - 1);
        sb = new StringBuilder();
        for (int j = 0; j < list.size(); j++) {
            String s = list.get(j);
            sb.append(s);
            for (int i = 0; i < size && j != list.size() - 1; i++) {
                sb.append(" ");
            }
        }
        int yu = list.size() == 1 ? empty : empty % (list.size() - 1);
        for (int i = 0; i < yu; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
