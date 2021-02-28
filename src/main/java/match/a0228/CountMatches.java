package match.a0228;

import java.util.List;

public class CountMatches {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int res = 0;
        for (List<String> item : items) {
            if (ruleKey.equals("type")) {
                if (item.get(0).equals(ruleValue)) {
                    res++;
                }
            }
            if (ruleKey.equals("color")) {
                if (item.get(1).equals(ruleValue)) {
                    res++;
                }
            }
            if (ruleKey.equals("name")) {
                if (item.get(2).equals(ruleValue)) {
                    res++;
                }
            }
        }
        return res;
    }
}
