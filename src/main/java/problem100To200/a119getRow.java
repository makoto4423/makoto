package problem100To200;

import java.util.ArrayList;
import java.util.List;

public class a119getRow {
    public List<Integer> getRow(int rowIndex) {
        int dep = 0;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        while (dep != rowIndex) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int i = 0; i < dep ; i++) {
                temp.add(list.get(i) + list.get(i + 1));
            }
            temp.add(1);
            list = temp;
            dep++;
        }
        return list;
    }
}
