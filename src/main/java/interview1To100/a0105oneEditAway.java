package interview1To100;

public class a0105oneEditAway {
    public boolean oneEditAway(String first, String second) {
        String lo = first.length() > second.length() ? first : second;
        String sh = first.length() > second.length() ? second : first;
        if (lo.length() - sh.length() > 1) return false;
        if (lo.length() - sh.length() == 1) {
            boolean dif = false;
            for (int i = 0, j = 0; i < sh.length() && j < lo.length(); i++, j++) {
                if (sh.charAt(i) == lo.charAt(j)) continue;
                if (!dif && j != lo.length()-1 && sh.charAt(i) == lo.charAt(j + 1)) {
                    dif = true;
                    j++;
                } else {
                    return false;
                }
            }
            return true;
        }
        boolean dif = false;
        for (int i = 0; i < sh.length(); i++) {
            if(sh.charAt(i) == lo.charAt(i)) {
            }else if (!dif){
                dif = true;
            }else{
                return false;
            }
        }
        return true;
    }
}
