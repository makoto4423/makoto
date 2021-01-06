package problem1500To1600;

public class a1576modifyString {
    public String modifyString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                int pre = -1, aft = -1;
                if (i != 0) {
                    pre = sb.charAt(sb.length() - 1) - 'a';
                }
                if (i != s.length() - 1) {
                    aft = s.charAt(i + 1) - 'a';
                }
                int select = 0;
                while (select == pre || select == aft){
                    select++;
                    if(select == 26) select = 0;
                }
                sb.append((char) (select + 'a'));
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
