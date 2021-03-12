package problem300To400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a331isValidSerialization {

    public boolean isValidSerialization(String preorder) {
        preorder = preorder.replaceAll(" ", "");
        List<String> list = Arrays.asList(preorder.split(","));
        List<String> next = new ArrayList<>();
        boolean remove = true;
        while (remove) {
            remove = false;
            int i = 0;
            for (; i < list.size() - 2; i++) {
                if (!list.get(i).equals("#") && list.get(i + 1).equals("#") && list.get(i + 2).equals("#")) {
                    next.add("#");
                    i += 2;
                    remove = true;
                } else {
                    next.add(list.get(i));
                }
            }
            for (; i < list.size(); i++) {
                next.add(list.get(i));
            }
            list = next;
            next = new ArrayList<>();
        }
        return list.size() == 1 && list.get(0).equals("#");
    }
}
