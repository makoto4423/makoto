package problem600To700;

import java.util.LinkedList;
import java.util.Queue;

public class a649predictPartyVictory {
    public String predictPartyVictory(String senate) {
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                r.add(i);
            } else {
                d.add(i);
            }
        }
        while (!r.isEmpty() && !d.isEmpty()) {
            Queue<Integer> usedR = new LinkedList<>();
            Queue<Integer> usedD = new LinkedList<>();
            while (!r.isEmpty() && !d.isEmpty()) {
                int ri = r.poll();
                int di = d.poll();
                if (ri < di) {
                    usedR.add(ri);
                } else {
                    usedD.add(di);
                }
            }
            while (!r.isEmpty() && !usedD.isEmpty()) {
                usedR.add(r.poll());
                usedD.poll();
            }
            while (!d.isEmpty() && !usedR.isEmpty()) {
                usedD.add(d.poll());
                usedR.poll();
            }
            r = usedR;
            d = usedD;
        }
        return r.isEmpty() ? "Dire" : "Radiant";
    }
}
