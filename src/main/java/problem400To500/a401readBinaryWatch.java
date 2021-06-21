package problem400To500;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class a401readBinaryWatch {

    List<String> res;

    public List<String> readBinaryWatch(int num) {
        res = new ArrayList<>();
        recur(new boolean[10], num, 0);
        return res;
    }

    public void recur(boolean[] arr, int num, int pos) {
        if (num == 0) {
            int hour = 0;
            int i = 0;
            for (; i < 4; i++) {
                hour = (hour << 1);
                if (arr[i]) {
                    hour++;
                }
            }
            int min = 0;
            for (; i < 10; i++) {
                min = (min << 1);
                if (arr[i]) {
                    min++;
                }
            }
            if (hour > 11 || min > 59) {
                return;
            }
            res.add(min < 10 ? hour + ":0" + min : hour + ":" + min);
            return;
        }
        if (pos == 10) return;
        for (int i = pos; i < 10; i++) {
            arr[i] = true;
            recur(arr, num - 1, i + 1);
            arr[i] = false;
        }
    }
}
